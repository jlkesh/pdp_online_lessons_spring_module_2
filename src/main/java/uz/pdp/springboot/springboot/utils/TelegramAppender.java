package uz.pdp.springboot.springboot.utils;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.google.common.hash.Hashing;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Aspect
@Component
public class TelegramAppender extends AppenderBase<LoggingEvent> {

    private final String chatID = "5270439889";
    private final String token = "6119464761:AAHsT8AiSPg0MNnXF7znuUxGCFvXIm9dZtg";
    private final TelegramBot telegramBot = new TelegramBot(token);

    public TelegramAppender() {
        addFilter(new Filter<>() {
            @Override
            public FilterReply decide(LoggingEvent loggingEvent) {
                return loggingEvent.getLevel().equals(Level.ERROR) ? FilterReply.ACCEPT : FilterReply.DENY;
            }
        });
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        SendMessage sendMessage = new SendMessage(chatID, loggingEvent.getFormattedMessage());
        sendMessage.parseMode(ParseMode.Markdown);
        telegramBot.execute(sendMessage);
    }
}