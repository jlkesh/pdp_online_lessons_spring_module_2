package uz.pdp.springboot.springboot.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Url extends Auditable {
    @Column(name = "path")
    private String path;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "description", length = 400)
    private String description;
}
