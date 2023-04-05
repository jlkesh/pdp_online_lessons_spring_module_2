package uz.pdp.springboot.springboot.post;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {
    @Override
    public EntityModel<Post> toModel(Post post) {
        Link selfRelation = linkTo(methodOn(PostController.class).getPost(post.getId())).withSelfRel();
        Link postsRelation = linkTo(methodOn(PostController.class).getPosts()).withRel("posts");
        return EntityModel.of(post, selfRelation, postsRelation);
    }

    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> entities) {
        List<EntityModel<Post>> entityModels = new ArrayList<>();
        entities.forEach(post -> entityModels.add(toModel(post)));
        Link postsRelation = linkTo(methodOn(PostController.class).getPosts()).withRel("posts");
        return CollectionModel.of(entityModels, postsRelation);
    }
}
