package uz.pdp.springboot.springboot.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.internal.RuntimeMetamodelsImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.springboot.springboot.config.security.SessionUser;
import uz.pdp.springboot.springboot.config.security.UserDetails;
import uz.pdp.springboot.springboot.dtos.url.DailyReport;
import uz.pdp.springboot.springboot.dtos.url.UrlReport;
import uz.pdp.springboot.springboot.dtos.url.WeaklyReport;
import uz.pdp.springboot.springboot.entities.Url;
import uz.pdp.springboot.springboot.mappers.UrlMapper;
import uz.pdp.springboot.springboot.repositories.UrlRepository;
import uz.pdp.springboot.springboot.utils.BaseUtils;
import uz.pdp.springboot.springboot.utils.MailSenderService;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
    private final UrlMapper urlMapper;
    private final BaseUtils utils;
    private final SessionUser sessionUser;
    private final UrlRepository urlRepository;
    private final MailSenderService mailSenderService;

    @Override
    public Url shortenUrl(@NonNull UrlCreateDTO dto) {
        Url url = urlMapper.toEntity(dto);
        url.setCode(utils.shortenUrlCode(sessionUser.id()));
        if (url.getExpiresAt() == null)
            url.setExpiresAt(LocalDateTime.now().plusDays(1));
        return urlRepository.save(url);
    }

    @Override
    public Url getByCode(@NonNull String code) {
        Url url = urlRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Url By Code not found"));
        if (url.getExpiresAt().isBefore(LocalDateTime.now()))
            throw new RuntimeException("Shortened Url Expired");
        return url;
    }

    @Override
    public Page<Url> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return urlRepository.findAllByUserID(sessionUser.id(), pageable);
    }

    @Override
    public WeaklyReport getWeaklyReport() {
        LocalDateTime from = LocalDateTime.now().minusWeeks(1).with(DayOfWeek.MONDAY);
        LocalDateTime to = LocalDateTime.now().minusWeeks(1).with(DayOfWeek.SUNDAY);
        List<Url> urls = urlRepository.findAllByUser(sessionUser.id(), from, to);
        AtomicInteger count = new AtomicInteger(0);

        List<DailyReport> dailyReports = new ArrayList<>();
        urls.stream()
                .map(UrlReport::new)
                .collect(Collectors.groupingBy(urlReport -> urlReport.getDayOfWeek().getValue()))
                .forEach((dayNumber, urlsReports) -> {
                    dailyReports.add(new DailyReport(dayNumber, urlsReports));
                    count.addAndGet(urlsReports.size());
                });
        return new WeaklyReport(
                utils.format(from),
                utils.format(to),
                dailyReports,
                count.get()
        );
    }

    @Override
    public void sendWeaklyReport() {
        WeaklyReport weaklyReport = getWeaklyReport();
        UserDetails user = sessionUser.user();
        String email = user.getEmail();
        Map<String, Object> model = Map.of("report", weaklyReport,
                "to", email,
                "username", user.getUsername()
        );
        mailSenderService.sendWeaklyReport(model);
    }
}
