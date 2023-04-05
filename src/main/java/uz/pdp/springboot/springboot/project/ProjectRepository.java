package uz.pdp.springboot.springboot.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("select p from Project p where upper(p.name) = upper(?1)")
    Optional<Project> findByName(String name);

    @Query("select p from Project p where upper(p.name) = upper(?1)")
    Collection<Project> findAllByName(String name);

    Optional<Project> findByNameIgnoreCaseAllIgnoreCase(String name);

}