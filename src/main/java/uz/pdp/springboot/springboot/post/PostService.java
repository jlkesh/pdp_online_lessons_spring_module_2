package uz.pdp.springboot.springboot.post;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.lang.NonNull;

public interface PostService {
    CollectionModel<EntityModel<Post>> getAll();

    PagedModel<EntityModel<Post>> getPage(int page, int size);

    EntityModel<Post> get(@NonNull Integer id);
}
