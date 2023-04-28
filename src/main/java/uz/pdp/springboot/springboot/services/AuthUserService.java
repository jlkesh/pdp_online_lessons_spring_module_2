package uz.pdp.springboot.springboot.services;

import org.springframework.lang.NonNull;
import uz.pdp.springboot.springboot.controllers.GenerateTokenRequest;
import uz.pdp.springboot.springboot.dto.auth.AuthUserCreateDto;

public interface AuthUserService {
    String register(@NonNull AuthUserCreateDto dto);

    String generateToken(@NonNull GenerateTokenRequest request);
}
