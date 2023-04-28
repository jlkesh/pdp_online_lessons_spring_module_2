package uz.pdp.springboot.springboot.services;

import org.springframework.lang.NonNull;
import uz.pdp.springboot.springboot.dtos.auth.GenerateTokenRequest;
import uz.pdp.springboot.springboot.dtos.auth.AuthUserCreateDto;

public interface AuthUserService {
    String register(@NonNull AuthUserCreateDto dto);

    String generateToken(@NonNull GenerateTokenRequest request);

    String activateAccount(@NonNull String code);
}
