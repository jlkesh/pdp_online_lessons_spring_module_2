package uz.pdp.springboot.springboot.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Component
public class MailSenderService {
    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public MailSenderService(JavaMailSender javaMailSender, Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    @Async
    public void sendFreeMarkerMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@mail.ru");
            mimeMessageHelper.setTo("to@gmail.com");
            mimeMessageHelper.setSubject("Subject From Test Simple Mail");
            Template template = configuration.getTemplate("activate_account.ftlh");
            String token = Base64.getEncoder().encodeToString(username.getBytes());
            Map<String, String> objectModel = Map.of("username", username, "token", token);
            String htmlMailContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, objectModel);
            mimeMessageHelper.setText(htmlMailContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}