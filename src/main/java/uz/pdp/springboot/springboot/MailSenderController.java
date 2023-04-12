package uz.pdp.springboot.springboot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/simple-mail")
    public String sendSimpleMail(@RequestParam String username) {
        mailSenderService.sendSimpleMail(username);
        return "Message Sent !!!";
    }
    @PostMapping("/html-mail")
    public String sendHtmlMail(@RequestParam String username) {
        mailSenderService.sendHTMLMail(username);
        return "Message Sent !!!";
    }
    @PostMapping("/attachment-mail")
    public String sendAttachmentMail(@RequestParam String username) {
        mailSenderService.sendAttachmentMail(username);
        return "Message Sent !!!";
    }
    @PostMapping("/image-mail")
    public String sendImageMail(@RequestParam String username) {
        mailSenderService.sendImageMail(username);
        return "Message Sent !!!";
    }

    @PostMapping("/freemarker-mail")
    public String sendFreeMarkerMail(@RequestParam String username) {
        mailSenderService.sendFreeMarkerMail(username);
        return "Message Sent !!!";
    }

}
