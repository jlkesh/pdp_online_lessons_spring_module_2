package uz.pdp.springboot.springboot.post;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post fromDTO(PostCreateDTO dto);
}
