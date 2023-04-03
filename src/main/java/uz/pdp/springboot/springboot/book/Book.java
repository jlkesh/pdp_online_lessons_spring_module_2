package uz.pdp.springboot.springboot.book;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "book_author", nullable = false)
    private String author;

}
