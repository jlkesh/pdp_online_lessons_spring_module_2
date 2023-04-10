package uz.pdp.springboot.springboot.post;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Post {
    private String id;
    private String title;
    private String body;
    private int viewCount;
    private int likeCount;
    private int dislikeCount;
    private int shareCount;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
