package uz.pdp.springboot.springboot;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;

@Component
public class MailSenderService {
    /*private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public MailSenderService(JavaMailSender javaMailSender,
                             Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    @Async
    public void sendSimpleMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom("from@mail.ru");
            mimeMessage.setRecipients(Message.RecipientType.TO, "to@gmail.com");
            mimeMessage.setSubject("Subject From Test Simple Mail");
            *//*mimeMessage.setText("Hello From PDP Online");*//*
            mimeMessage.setContent("<h1 style=\"color: red;\">Hello From PDP Online</h1>", "text/html");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendHTMLMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom("from@mail.ru");
            mimeMessage.setRecipients(Message.RecipientType.TO, "to@gmail.com");
            mimeMessage.setSubject("Subject From Test Simple Mail");
            Path path = Path.of("src/main/resources/activate.html");
            String htmlMailContent = Files.readString(path);
            htmlMailContent = htmlMailContent.formatted(username);
            mimeMessage.setContent(htmlMailContent, "text/html");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendAttachmentMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@mail.ru");
            mimeMessageHelper.setTo("to@gmail.com");
            mimeMessageHelper.setSubject("Subject From Test Simple Mail");

            Path path = Path.of("src/main/resources/activate.html");
            Path imgPath = Path.of("src/main/resources/img.jpg");
            Path pdfPath = Path.of("src/main/resources/jvm.pdf");
            FileSystemResource imSystemResource = new FileSystemResource(imgPath);
            FileSystemResource pdfSystemResource = new FileSystemResource(pdfPath);
            String htmlMailContent = Files.readString(path);
            htmlMailContent = htmlMailContent.formatted(username);

            mimeMessageHelper.setText(htmlMailContent, true);
            mimeMessageHelper.addAttachment("Nature.jpg", imSystemResource);
            mimeMessageHelper.addAttachment("JvmInternals.pdf", pdfSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendImageMail(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username + "@mail.ru");
            mimeMessageHelper.setTo("to@gmail.com");
            mimeMessageHelper.setSubject("Subject From Test Simple Mail");

            Path path = Path.of("src/main/resources/activate.html");
            Path imgPath = Path.of("src/main/resources/img.jpg");
            *//*Base64.Encoder encoder = Base64.getEncoder();
            String imageAsBase64 = encoder.encodeToString(Files.readAllBytes(imgPath));*//*
            String htmlMailContent = Files.readString(path);
            *//*htmlMailContent = htmlMailContent.formatted(imageAsBase64);*//*
            mimeMessageHelper.setText(htmlMailContent, true);
            mimeMessageHelper.addInline("image_id", new FileSystemResource(imgPath));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
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
    }*/
}
