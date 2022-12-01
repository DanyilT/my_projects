package org.dany_inc.telegram_bot.handlers;
/*
Created by: Dany
Created on 25/11/2022 : 15:10
This is program to
*/

import org.dany_inc.telegram_bot.messagesender.MessageSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;

@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {
    private final MessageSender messageSender;

    public CallbackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(CallbackQuery callbackQuery) {
        if (callbackQuery.getData().equals("next_poem")) {
            String poemText = "Text_2";
            Integer messageId = callbackQuery.getMessage().getMessageId();
            var editMessageText = new EditMessageText();
            editMessageText.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
            editMessageText.setMessageId(messageId);
            editMessageText.setText(poemText);
            editMessageText.setReplyMarkup(
                    InlineKeyboardMarkup.builder()
                            .keyboardRow(Collections.singletonList(InlineKeyboardButton.builder()
                                    .text("url")
                                    .url("https://google.com").build())).build()
            );
            messageSender.sendEditMessage(editMessageText);
        }
    }
}
