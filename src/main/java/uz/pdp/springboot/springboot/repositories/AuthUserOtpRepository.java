package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot.springboot.entities.AuthUserOtp;

public interface AuthUserOtpRepository extends JpaRepository<AuthUserOtp, Long> {
}