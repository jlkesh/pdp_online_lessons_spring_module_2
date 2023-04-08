package uz.pdp.springboot.springboot.post;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot.springboot.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        Post comment = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> comments = postRepository.findAll();
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        Post comment = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        postRepository.delete(comment);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Post> savePost(@RequestBody Post comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(comment));
    }
}
