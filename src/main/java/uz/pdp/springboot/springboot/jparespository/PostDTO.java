package uz.pdp.springboot.springboot.jparespository;

import lombok.Getter;

@Getter
public class PostDTO {
    Integer id;

    String title;

    public PostDTO(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
