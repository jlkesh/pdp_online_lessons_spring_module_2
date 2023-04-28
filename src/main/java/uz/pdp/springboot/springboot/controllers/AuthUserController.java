package uz.pdp.springboot.springboot.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot.springboot.dtos.auth.AuthUserCreateDto;
import uz.pdp.springboot.springboot.dtos.auth.GenerateTokenRequest;
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

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateAccount(@PathVariable String code) {
        return ResponseEntity.ok(authUserService.activateAccount(code));
    }

    // TODO: 29/04/23 activation code ni qayta jo'natadigan api qo'shish kerak (email)

}
