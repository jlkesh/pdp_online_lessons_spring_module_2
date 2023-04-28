package uz.pdp.springboot.springboot.post;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostModelAssembler postModelAssembler;
    private final PagedResourcesAssembler<Post> pagedResourcesAssembler;

    public PostServiceImpl(PostRepository postRepository, PostModelAssembler postModelAssembler, @Qualifier("postPagedResourcesAssembler") PagedResourcesAssembler<Post> pagedResourcesAssembler) {
        this.postRepository = postRepository;
        this.postModelAssembler = postModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public CollectionModel<EntityModel<Post>> getAll() {
        List<Post> posts = postRepository.findAll();
        return postModelAssembler.toCollectionModel(posts);
    }

    public PagedModel<EntityModel<Post>> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postRepository.findAll(pageable);
        return pagedResourcesAssembler.toModel(posts, postModelAssembler);
    }

    public EntityModel<Post> get(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return postModelAssembler.toModel(post);
    }
}
