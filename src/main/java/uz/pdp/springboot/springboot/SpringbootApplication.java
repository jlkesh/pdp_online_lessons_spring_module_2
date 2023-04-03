package uz.pdp.springboot.springboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.springboot.springboot.jparespository.Post;
import uz.pdp.springboot.springboot.jparespository.PostRepository;

import java.net.URL;
import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    // @Bean
    ApplicationRunner runner(PostRepository postRepository,
                             ObjectMapper objectMapper) {
        return (args) -> {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post> posts = objectMapper.readValue(url, new TypeReference<>() {
            });
            postRepository.saveAll(posts);
        };
    }

}
