package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.springboot.springboot.entities.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    @Transactional
    @Modifying
    @Query("update AuthUser a set a.active = true where a.id = ?1 and a.deleted = false")
    void activateUser(Long id);

    @Query("select a from AuthUser a where upper(a.email) = upper(?1) and a.deleted =  false ")
    Optional<AuthUser> findByEmail(String email);

    @Query("select a from AuthUser a where upper(a.username) = upper(?1) and a.deleted = false")
    Optional<AuthUser> findByUsername(String username);

}