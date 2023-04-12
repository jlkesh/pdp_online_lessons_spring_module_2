package uz.pdp.springboot.springboot;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api/mail")
@Slf4j
public class MailSenderController {

    /*private final Logger log = LoggerFactory.getLogger(MailSenderController.class);*/
    private final MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/simple-mail")
    public String sendSimpleMail(@RequestParam String username) {
        // mailSenderService.sendSimpleMail(username);
//        for (int i = 0; i < 1000; i++) {
            log.info("Simple Mail Sent username : {}| Time : {}", username, new Date());
//        }
        return "Message Sent !!!";
    }

    @PostMapping("/html-mail")
    public String sendHtmlMail(@RequestParam String username) {
        // mailSenderService.sendHTMLMail(username);
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Error For New Custom Appender");
        } else {
            log.info("HTML Mail Sent username : {}", username);
        }
        return "Message Sent !!!";
    }

    @PostMapping("/attachment-mail")
    public String sendAttachmentMail(@RequestParam String username) {
        // mailSenderService.sendAttachmentMail(username);
        return "Message Sent !!!";
    }

    @PostMapping("/image-mail")
    public String sendImageMail(@RequestParam String username) {
        // mailSenderService.sendImageMail(username);
        return "Message Sent !!!";
    }

    @PostMapping("/freemarker-mail")
    public String sendFreeMarkerMail(@RequestParam String username) {
        // mailSenderService.sendFreeMarkerMail(username);

        return "Message Sent !!!";
    }

}
