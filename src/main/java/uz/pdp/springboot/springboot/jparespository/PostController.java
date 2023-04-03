package uz.pdp.springboot.springboot.jparespository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final CustomPostRepository customPostRepository;

    public PostController(PostRepository postRepository, CustomPostRepository customPostRepository) {
        this.postRepository = postRepository;
        this.customPostRepository = customPostRepository;
    }

    @GetMapping
    public Page<Post> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("userId"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return postRepository.findAll(pageable);
    }

    @GetMapping("/paged")
    public Page<Post> getAllPaged(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("user_id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return postRepository.getAllPostsPaged(pageable);
    }

    @GetMapping("/byusers/{userIds}")
    public List<Post> getAllPaged(@PathVariable Collection<Integer> userIds) {
        return postRepository.getAllPostsByUserIds(userIds);
    }

    @GetMapping("/{userId}")
    public List<Post> getAllByCreatorID(@PathVariable Integer userId) {
        return postRepository.getAllPostsByUserId(userId);
    }

    @DeleteMapping("/{userId}")
    /*@ResponseStatus(HttpStatus.NO_CONTENT)*/
    public ResponseEntity<?> deletePostsByUserId(@PathVariable Integer userId) {
        postRepository.deletePostsByUserId(userId);
        /*return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);*/
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sortbyid")
    public List<Post> getAllPostsWithSortedColumns() {
        /*Sort sort = Sort.by(Sort.Direction.DESC, "title")
                .and(Sort.by(Sort.Direction.ASC, "id"));*/
        Sort.Order title = Sort.Order.desc("title");
        Sort.Order id = Sort.Order.asc("id");
        Sort sort = Sort.by(title, id);
        return postRepository.findAll(sort);
    }


    @PostMapping
    public Post save(@RequestBody Post post) {
        return customPostRepository.save(post);
    }
}
