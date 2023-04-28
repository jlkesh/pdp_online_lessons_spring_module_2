package uz.pdp.springboot.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Url extends Auditable {

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String url;

    private String description;

    @Future
    @Column(nullable = false)
    private LocalDateTime expiresAt;

}
