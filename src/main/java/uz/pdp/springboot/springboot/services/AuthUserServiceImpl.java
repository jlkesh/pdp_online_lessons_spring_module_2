package uz.pdp.springboot.springboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.springboot.springboot.config.security.JwtTokenUtil;
import uz.pdp.springboot.springboot.dtos.auth.GenerateTokenRequest;
import uz.pdp.springboot.springboot.dtos.auth.AuthUserCreateDto;
import uz.pdp.springboot.springboot.entities.AuthUser;
import uz.pdp.springboot.springboot.entities.AuthUserOtp;
import uz.pdp.springboot.springboot.mappers.AuthUserMapper;
import uz.pdp.springboot.springboot.repositories.AuthUserOtpRepository;
import uz.pdp.springboot.springboot.repositories.AuthUserRepository;
import uz.pdp.springboot.springboot.utils.MailSenderService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserMapper authUserMapper;
    private final AuthUserRepository authUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final MailSenderService mailSenderService;
    private final AuthUserOtpService authUserOtpService;
    private final AuthUserOtpRepository authUserOtpRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(@NonNull AuthUserCreateDto dto) {
        AuthUser authUser = authUserMapper.toEntity(dto);
        if (authUserRepository.findByEmail(dto.getEmail()).isPresent())
            throw new RuntimeException("Email Already Taken");

        if (authUserRepository.findByUsername(dto.getUsername()).isPresent())
            throw new RuntimeException("Username Already Taken");

        authUser.setRole("USER");
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUserRepository.save(authUser);
        AuthUserOtp authUserOtp = authUserOtpService.createOTP(authUser);
        Map<String, String> model = new HashMap<>();
        model.put("to", authUser.getEmail());
        model.put("code", authUserOtp.getCode());
        mailSenderService.sendActivationMail(model);
        return "Success";
    }

    @Override
    public String generateToken(@NonNull GenerateTokenRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        var authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(username);
    }

    @Override
    public String activateAccount(@NonNull String code) {
        AuthUserOtp otp = authUserOtpRepository.findByCodeIgnoreCase(code)
                .orElseThrow(() -> new RuntimeException("Invalid Code"));

        if (otp.getExpiresAt().isBefore(LocalDateTime.now()))
            // TODO: 29/04/23 deleted true qilib qo'yish kerak
            throw new RuntimeException("Code is expired");

        Long userID = otp.getUserID();
        authUserRepository.activateUser(userID);
        return "Account Successfully Activated";
    }

}
