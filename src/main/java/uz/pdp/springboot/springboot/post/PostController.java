package uz.pdp.springboot.springboot.post;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Post>> getPosts() {
        return postService.getAll();
    }

    @GetMapping("/paged")
    public PagedModel<EntityModel<Post>> getPage(@RequestParam(required = false, defaultValue = "10") int size, @RequestParam(required = false, defaultValue = "0") int page) {
        return postService.getPage(page, size);
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPost(@PathVariable Integer id) {
        return postService.get(id);
    }

}