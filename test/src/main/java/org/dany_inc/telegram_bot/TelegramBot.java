package org.dany_inc.telegram_bot;
/*
Created by: Dany
Created on 24/11/2022 : 10:14
This is program to
*/

import org.dany_inc.telegram_bot.processor.Processor;
import org.dany_inc.telegram_bot.services.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String username;
    @Value("${telegram.bot.token}")
    private String token;

    private SendMessageService sendMessageService;

    private Processor processor;

    public TelegramBot(Processor processor) {
        this.processor = processor;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        processor.process(update);

        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                sendMessageService.test1(message);
                sendMessageService.test2(message);
                String text = message.getText();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Its your text : " + text);
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}