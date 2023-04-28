package uz.pdp.springboot.springboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import uz.pdp.springboot.springboot.config.security.JwtTokenUtil;
import uz.pdp.springboot.springboot.controllers.GenerateTokenRequest;
import uz.pdp.springboot.springboot.dto.auth.AuthUserCreateDto;
import uz.pdp.springboot.springboot.entities.AuthUser;
import uz.pdp.springboot.springboot.mappers.AuthUserMapper;
import uz.pdp.springboot.springboot.repositories.AuthUserRepository;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserMapper authUserMapper;
    private final AuthUserRepository authUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public String register(@NonNull AuthUserCreateDto dto) {
        AuthUser authUser = authUserMapper.toEntity(dto);
        authUserRepository.save(authUser);
        // TODO: 28/04/23 send Activation Mail
        return "Success";
    }

    @Override
    public String generateToken(@NonNull GenerateTokenRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwtTokenUtil.generateToken(username);
    }
}
