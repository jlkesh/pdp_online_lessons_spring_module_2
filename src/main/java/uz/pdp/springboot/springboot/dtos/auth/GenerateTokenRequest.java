package uz.pdp.springboot.springboot.dtos.auth;

import jakarta.validation.constraints.NotBlank;
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
public class GenerateTokenRequest implements Serializable {
    @NotBlank private String username;
    @NotBlank private String password;
}