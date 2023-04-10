package uz.pdp.springboot.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ReportSenderService {

    /*ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());*/

    @Async
    public void sendReport(String username) {

        try {
            TimeUnit.SECONDS.sleep(5);
            // sent report to gmail
        } catch (Exception ignored) {
        }
        log.info("Report Sent !!!");
        throw new RuntimeException("Runtime Exception " + LocalDate.now());
        /*executorService.submit(runnable);*/
        /*CompletableFuture.runAsync(runnable);*/
    }
}
