package uz.pdp.springboot.springboot.jparespository;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Post.getAllPostsByUserID",
                query = "select p from Post p where p.userId = ?1"
        )
})
@SqlResultSetMapping(
        name = "PostDTO_MAPPING",
        classes = @ConstructorResult(
                targetClass = PostDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "title", type = String.class)
                }
        )
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Post.getAllPostsByUserID.Native",
                query = "select p.* from post p where p.user_id = ?1",
                resultClass = Post.class
        ),
        @NamedNativeQuery(
                name = "Post.find.all.by.projection",
                query = "select p.id, p.title from post p",
                resultSetMapping = "PostDTO_MAPPING"
        )
})
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer userId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;

}
