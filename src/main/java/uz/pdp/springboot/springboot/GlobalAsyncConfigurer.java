package uz.pdp.springboot.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

@Configuration
@Slf4j
public class GlobalAsyncConfigurer implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (e, method, params) -> {
            log.error("Error : On Method : {}, Input Parameters : {}", method.getName(), params);
            e.printStackTrace();
        };
    }
}
