package uz.pdp.springboot.springboot.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot.springboot.dto.auth.AuthUserCreateDto;
import uz.pdp.springboot.springboot.services.AuthUserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthUserService authUserService;


    @PostMapping("/generate-token")
    public ResponseEntity<String> generateToken(@Valid @RequestBody GenerateTokenRequest request) {
        return ResponseEntity.ok(authUserService.generateToken(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody AuthUserCreateDto dto) {
        return ResponseEntity.status(201).body(authUserService.register(dto));
    }
    // activate account
    // send activation code
}
