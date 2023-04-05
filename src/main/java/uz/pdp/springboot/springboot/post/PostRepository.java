package uz.pdp.springboot.springboot.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource(path = "maqolalar", collectionResourceRel = "maqolalar")
public interface PostRepository extends JpaRepository<Post, Integer> {

    Collection<Post> findAllByTitleStartingWith(String title);

}