package uz.pdp.springboot.springboot.utils;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

@Component
public class BaseUtils {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Base64.Encoder encoder = Base64.getUrlEncoder();

    public String generateOtp(Long userID) {
        return encoder.encodeToString((UUID.randomUUID().toString() + userID).getBytes());
    }

    public String shortenUrlCode(long userID) {
        return Hashing
                .murmur3_32_fixed()
                .hashString(UUID.randomUUID().toString() + userID, StandardCharsets.UTF_8)
                .toString();
    }

    public String format(LocalDateTime localDateTime) {
        return FORMATTER.format(localDateTime);
    }
}
