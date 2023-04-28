package uz.pdp.springboot.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.pdp.springboot.springboot.config.security.SessionUser;
import uz.pdp.springboot.springboot.dtos.url.WeaklyReport;
import uz.pdp.springboot.springboot.services.UrlService;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableScheduling
public class SpringbootApplication {
    private final UrlService urlService;

    public SpringbootApplication(UrlService urlService) {
        this.urlService = urlService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return (args -> {
        });
    }

    @Bean
    public AuditorAware<Long> getAuditor(SessionUser sessionUser) {
        return () -> Optional.of(sessionUser.id());
    }

    @Scheduled(cron = "0 0 9 * * MON")
    public void sendWeaklyReportOnMonday() {
        urlService.sendWeaklyReport();
    }
}
