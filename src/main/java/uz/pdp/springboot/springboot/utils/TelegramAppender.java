package uz.pdp.springboot.springboot.utils;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

@Component
public class TelegramAppender extends AppenderBase<LoggingEvent> {
    private static final String botToken = "6119464761:AAGBu2CIA-6dgbadAdlrF3umC19UqM3iYgo";
    private static final String chatID = "5270439889";
    private static final TelegramBot telegramBot = new TelegramBot(botToken);

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
        String logMessage = loggingEvent.toString();
        SendMessage sendMessage = new SendMessage(chatID, logMessage);
        telegramBot.execute(sendMessage);
    }
}