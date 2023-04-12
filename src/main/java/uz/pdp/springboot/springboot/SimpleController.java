package uz.pdp.springboot.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {
    private final ReportSenderService reportSenderService;

    @Value("${example}")
    private String example;


    public SimpleController(ReportSenderService reportSenderService) {
        this.reportSenderService = reportSenderService;
    }

    @GetMapping("/sendReport")
    public String sendReport() {
        reportSenderService.sendReport("Javohir");
        return "Report sent Successfully";
    }

    @GetMapping("/example")
    public String example() {
        return example;
    }

   /* @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }*/

}
