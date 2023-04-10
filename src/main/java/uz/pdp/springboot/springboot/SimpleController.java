package uz.pdp.springboot.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {
    private final ReportSenderService reportSenderService;

    public SimpleController(ReportSenderService reportSenderService) {
        this.reportSenderService = reportSenderService;
    }

    @GetMapping("/sendReport")
    public String sendReport() {
        reportSenderService.sendReport("Javohir");
        return "Report sent Successfully";
    }
}
