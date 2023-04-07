package uz.pdp.springboot.springboot.dto;

import lombok.Getter;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class AppErrorDto {
    private String errorMessage;
    private String errorPath;
    private Integer errorCode;
    private LocalDateTime timestamp;

    public AppErrorDto(String errorMessage, String errorPath, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    }
}
