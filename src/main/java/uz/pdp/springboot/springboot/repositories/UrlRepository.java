package uz.pdp.springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot.springboot.entities.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {
}