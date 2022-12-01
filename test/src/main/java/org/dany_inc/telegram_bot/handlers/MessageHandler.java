package org.dany_inc.telegram_bot.handlers;
/*
Created by: Dany
Created on 25/11/2022 : 15:09
This is program to
*/

import org.dany_inc.telegram_bot.cache.Cache;
import org.dany_inc.telegram_bot.domain.BotUser;
import org.dany_inc.telegram_bot.domain.Position;
import org.dany_inc.telegram_bot.messagesender.MessageSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MessageHandler implements Handler<Message> {

    private final MessageSender messageSender;
    private final Cache<BotUser> cache;

    public MessageHandler(MessageSender messageSender, Cache<BotUser> cache) {
        this.messageSender = messageSender;
        this.cache = cache;
    }
    
    private BotUser generateUserFromMessage(Message message) {
        BotUser user = new BotUser();
        user.setUsername(message.getFrom().getUserName());
        user.setId(message.getChatId());
        user.setPosition(Position.INPUT_USERNAME);
        return user;
    }
    @Override
    public void choose(Message message) {
        BotUser user = cache.findBy(message.getChatId());
        if (user!=null) {
            switch (user.getPosition()) {
                case INPUT_USERNAME:
                    user.setFullName(message.getText());
                    user.setPosition(Position.INPUT_PHONE_NUMBER);
                    messageSender.sendMessage(
                            SendMessage.builder()
                                    .text("Tap and send me your phone number")
                                    .chatId(String.valueOf(message.getChatId()))
                                    .replyMarkup(ReplyKeyboardMarkup.builder()
                                            .oneTimeKeyboard(true)
                                            .resizeKeyboard(true)
                                            .keyboardRow(new KeyboardRow() {{
                                                add(KeyboardButton.builder()
                                                        .text("Send phone number")
                                                        .requestContact(true)
                                                        .build());
                                            }}).build())
                                    .build());
                    break;
                case INPUT_PHONE_NUMBER:
                    if (message.hasContact()) {
                        user.setPhoneNumber(message.getContact().getPhoneNumber());
                        user.setPosition(Position.NONE);
                        messageSender.sendMessage(
                                SendMessage.builder()
                                        .text("<b>Id </b><code>" + user.getId() + "</code>\n<b>Name </b><code>" + user.getFullName() + "</code>\n<b>Phone number </b><code>" + user.getPhoneNumber() + "</code>")
                                        .parseMode("HTML")
                                        .chatId(String.valueOf(message.getChatId()))
                                        .build());
                    }
                    break;
            }
        } else if (message.hasText()) {
            if (message.getText().equals("/reg")) {
                cache.add(generateUserFromMessage(message));
                messageSender.sendMessage(
                        SendMessage.builder()
                                .text("Enter your NAME")
                                .chatId(String.valueOf(message.getChatId()))
                                .build());
            }
            else if (message.getText().equals("/get_poem")) {
                SendMessage sendMessage =new SendMessage();
                sendMessage.setChatId(String.valueOf(message.getChatId()));

                sendMessage.setText("Text_1");

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                keyboard
                        .add(Collections
                                .singletonList(new InlineKeyboardButton()
                                        .builder()
                                        .text("Next")
                                        .callbackData("next_poem")
                                        .build()));
                inlineKeyboardMarkup.setKeyboard(keyboard);
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                messageSender.sendMessage(sendMessage);
            }
        }
    }
}
