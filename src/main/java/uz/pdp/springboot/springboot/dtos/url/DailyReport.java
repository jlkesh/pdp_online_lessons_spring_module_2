package uz.pdp.springboot.springboot.dtos.url;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
public class DailyReport {
    private String dayName;
    private Integer dayNumber;
    private Integer count;
    private List<UrlReport> reports;

    public DailyReport(Integer dayNumber, List<UrlReport> reports) {
        this.dayNumber = dayNumber;
        this.dayName = DayOfWeek.of(dayNumber).name();
        this.reports = reports;
        this.count = reports.size();
    }
}
