package org.example.bot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.ArrayList;
import java.util.List;

public class TailorPedenBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Tailor_Peden_bot";
    }

    @Override
    public String getBotToken() {
        return "6732381182:AAE0ARfg5BPiR7b3XIG0qL6C-5q06B_vwbs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (message.equals("Сайт")) {
                sendSaitMessage(chatId);
            } else if (message.equals("/start")) {
                sendStartMessage(chatId);
            } else if (message.equals("Информация о боте")) {
                sendInfoMessage(chatId);
            }else if (message.equals("Эмодзи")){
                sendEmojiMessage(chatId);
            }else if (message.equals("Привет)")){
                sendHiMessage(chatId);
            }
        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

        }
    }



    private void sendStartMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Приветствую! Я бот Tailor_Peden_bot.\n" +
                "Вот что я умею");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();
        row1.add(new KeyboardButton("Сайт"));
        row2.add(new KeyboardButton("Информация о боте"));
        row3.add(new KeyboardButton("Эмодзи"));
        row4.add(new KeyboardButton("Привет)"));
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendInfoMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Информация о боте:\n\n" +
                "Название: Tailor_Peden_bot\n" +
                "Версия: 3.6.2");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendEmojiMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("✋ \uD83D\uDE0F \uD83D\uDCFA \uD83D\uDC69\u200D\uD83E\uDDAF \uD83E\uDD2C \uD83E\uDD75");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendHiMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Ну привет)");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendSaitMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Вот ( •̀ ω •́ )✧"+ "\nhttps://www.youtube.com/watch?v=dQw4w9WgXcQ&t=3s");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}