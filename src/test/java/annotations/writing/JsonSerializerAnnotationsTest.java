package annotations.writing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JsonSerializerAnnotationsTest {


    @Test
    void jsonIncludeTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("");
        /*post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto")
        post.setDate(new Date());*/
        System.out.println(mapper.writeValueAsString(post));
    }

    @Test
    void jsonGetterTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        post.setDate(new Date());
        System.out.println(mapper.writeValueAsString(post));
    }

    @Test
    void jsonAnyGetterTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PostWithoutGetterAndSetters post = new PostWithoutGetterAndSetters(1, 1,
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
                new Date());
        System.out.println(mapper.writeValueAsString(post));
    }

    @Test
    void jsonPropertyOrder() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        post.setDate(new Date());
        System.out.println(mapper.writeValueAsString(post));
    }

}
