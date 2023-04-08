package uz.pdp.springboot.springboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uz.pdp.springboot.springboot.comment.Comment;
import uz.pdp.springboot.springboot.comment.CommentRepository;
import uz.pdp.springboot.springboot.post.Post;
import uz.pdp.springboot.springboot.post.PostRepository;
import uz.pdp.springboot.springboot.todo.Todo;
import uz.pdp.springboot.springboot.todo.TodoRepository;

import java.net.URL;
import java.util.List;

@SpringBootApplication
/*@OpenAPIDefinition(
        info = @Info(
                title = "PDP Online Java(SpringDOC)",
                version = "10",
                contact = @Contact(
                        name = "Elmurodov Javohir",
                        email = "john.lgd65@gmail.com",
                        url = "https://github.com/jlkesh"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"
                ),
                termsOfService = "http://swagger.io/terms/",
                description = "This Document Designed For Teaching SpringDOC Project"
        ),
        externalDocs = @ExternalDocumentation(
                description = "SpringDOC version 2",
                url = "https://springdoc.org/v/2"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)*/
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(
            ObjectMapper objectMapper,
            PostRepository postRepository,
            CommentRepository commentRepository,
            TodoRepository todoRepository) {
        return (args -> {
            List<Comment> comments = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<>() {
            });
            commentRepository.saveAll(comments);
            List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {
            });
            postRepository.saveAll(posts);
            List<Todo> todos = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<>() {
            });
            todoRepository.saveAll(todos);
        });
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*");
            }
        };
    }


    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PDP Online Java(SpringDOC)")
                        .description("This Document Designed For Teaching SpringDOC Project")
                        .version("10")
                        .contact(new Contact()
                                .name("Elmurodov Javohir")
                                .email("john.lgd65@gmail.com")
                                .url("https://github.com/jlkesh"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Production Server"),
                        new Server().url("http://localhost:9090").description("Test Server")
                )).addSecurityItem(new SecurityRequirement().addList("basicAuth","bearerAuth"))
                .components((new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .name("basicAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic"))
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                ));
    }

    @Bean
    public GroupedOpenApi postOpenApi() {
        return GroupedOpenApi.builder()
                .group("post")
                .pathsToMatch("/api/posts/**")
                .build();
    }
    @Bean
    public GroupedOpenApi commentOpenApi() {
        return GroupedOpenApi.builder()
                .group("comment")
                .pathsToMatch("/api/comments/**")
                .build();
    }
    @Bean
    public GroupedOpenApi todoOpenApi() {
        return GroupedOpenApi.builder()
                .group("todo")
                .pathsToMatch("/api/todos/**")
                .build();
    }


}
