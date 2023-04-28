package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springboot.springboot.entities.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    @Query("select a from AuthUser a where upper(a.username) = upper(?1) and a.deleted = false")
    Optional<AuthUser> findByUsername(String username);

}