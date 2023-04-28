package uz.pdp.springboot.springboot.services;

import org.springframework.lang.NonNull;
import uz.pdp.springboot.springboot.entities.AuthUser;
import uz.pdp.springboot.springboot.entities.AuthUserOtp;

public interface AuthUserOtpService {

    AuthUserOtp create(@NonNull AuthUserOtp authUserOtp);

    AuthUserOtp createOTP(@NonNull AuthUser authUser);
}
