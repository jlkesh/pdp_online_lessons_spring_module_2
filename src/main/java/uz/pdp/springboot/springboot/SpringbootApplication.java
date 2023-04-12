package uz.pdp.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


/*    @Bean
    @Profile("dev")
    public TaskExecutor taskExecutorDev() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setKeepAliveSeconds(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setThreadNamePrefix("dev-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean
    @Profile("test")
    public TaskExecutor taskExecutorTest() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setKeepAliveSeconds(15);
        taskExecutor.setQueueCapacity(40);
        taskExecutor.setThreadNamePrefix("test-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean
    @Profile("prod")
    public TaskExecutor taskExecutorProd() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setQueueCapacity(500);
        taskExecutor.setThreadNamePrefix("prod-");
        taskExecutor.initialize();
        return taskExecutor;
    }*/

}
