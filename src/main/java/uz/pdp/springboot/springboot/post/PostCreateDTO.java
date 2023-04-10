package uz.pdp.springboot.springboot.post;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostCreateDTO {
    private String title;
    private String body;
}
