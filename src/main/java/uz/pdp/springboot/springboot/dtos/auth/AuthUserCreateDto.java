package uz.pdp.springboot.springboot.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDto implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}