package uz.pdp.springboot.springboot.services;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link uz.pdp.springboot.springboot.entities.Url} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlCreateDTO implements Serializable {
    private String url;
    private String description;
    @Future
    private LocalDateTime expiresAt;
}