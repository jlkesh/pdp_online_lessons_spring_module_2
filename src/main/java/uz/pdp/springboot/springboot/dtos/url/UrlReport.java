package uz.pdp.springboot.springboot.dtos.url;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.springboot.springboot.entities.Url;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
public class UrlReport {
    private String code;
    private String url;
    private String description;
    private DayOfWeek dayOfWeek;
    private boolean expired;

    public UrlReport(Url url) {
        this.code = url.getCode();
        this.description = url.getDescription();
        this.url = url.getUrl();
        this.dayOfWeek = url.getCreatedAt().getDayOfWeek();
        this.expired = url.getExpiresAt().isBefore(LocalDateTime.now());
    }
}
