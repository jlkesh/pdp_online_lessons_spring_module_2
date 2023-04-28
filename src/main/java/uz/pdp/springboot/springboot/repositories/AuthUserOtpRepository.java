package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springboot.springboot.entities.AuthUserOtp;

import java.util.Optional;

public interface AuthUserOtpRepository extends JpaRepository<AuthUserOtp, Long> {
    @Query("select a from AuthUserOtp a where upper(a.code) = upper(?1) and a.deleted = false")
    Optional<AuthUserOtp> findByCodeIgnoreCase(String code);
}