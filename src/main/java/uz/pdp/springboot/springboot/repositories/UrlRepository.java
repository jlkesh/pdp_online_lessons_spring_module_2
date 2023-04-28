package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springboot.springboot.entities.Url;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query("select u from Url u where u.createdBy = ?1 and u.createdAt between ?2 and ?3 and u.deleted = false ")
    List<Url> findAllByUser(Long userID, LocalDateTime from, LocalDateTime to);
    @Query("select u from Url u where upper(u.code) = upper(?1) and u.deleted = false ")
    Optional<Url> findByCode(String code);

    @Query("select u from Url u where u.createdBy = ?1 and u.deleted = false")
    Page<Url> findAllByUserID(Long createdBy, Pageable pageable);


}