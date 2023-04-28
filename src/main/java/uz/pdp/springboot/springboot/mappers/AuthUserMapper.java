package uz.pdp.springboot.springboot.mappers;

import org.mapstruct.*;
import uz.pdp.springboot.springboot.dto.auth.AuthUserCreateDto;
import uz.pdp.springboot.springboot.entities.AuthUser;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthUserMapper {
    AuthUser toEntity(AuthUserCreateDto authUserCreateDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthUser partialUpdate(AuthUserCreateDto authUserCreateDto, @MappingTarget AuthUser authUser);
}