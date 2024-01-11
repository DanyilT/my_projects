package org.dany_inc.telegramBot;
/*
Created by: Dany
Created on 24/11/2022 : 10:14
This is program to
*/

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.dany_inc.process.NumOfGame.initNumOfGame;
import static org.dany_inc.process.Process.process;

public class TelegramBot extends TelegramLongPollingBot {
    public TelegramBot() {
        initNumOfGame();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            String response = process(message);

            sendText(update.getMessage().getChatId(), response);
        }
    }

    private void sendText(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Dany_GameBot";
    }

    @Override
    public String getBotToken() {
        return "5866688602:AAHX8raRldujdbk6TcWrTUD14tJkZK-TYm4";
    }
}