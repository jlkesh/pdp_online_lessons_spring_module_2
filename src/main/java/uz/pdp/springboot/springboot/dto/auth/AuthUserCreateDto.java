package uz.pdp.springboot.springboot.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link uz.pdp.springboot.springboot.entities.AuthUser} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDto implements Serializable {
    private String username;
    private String password;
    private String email;
}