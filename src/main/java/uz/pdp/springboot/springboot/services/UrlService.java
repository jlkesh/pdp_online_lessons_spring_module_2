package uz.pdp.springboot.springboot.services;

import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import uz.pdp.springboot.springboot.dtos.url.WeaklyReport;
import uz.pdp.springboot.springboot.entities.Url;

public interface UrlService {
    Url shortenUrl(@NonNull UrlCreateDTO dto);

    Url getByCode(@NonNull String code);

    Page<Url> getPage(int page, int size);

    WeaklyReport getWeaklyReport();
    void sendWeaklyReport();
}
