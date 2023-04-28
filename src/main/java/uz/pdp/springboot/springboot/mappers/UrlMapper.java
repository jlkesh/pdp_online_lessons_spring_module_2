package uz.pdp.springboot.springboot.mappers;

import org.mapstruct.*;
import uz.pdp.springboot.springboot.entities.Url;
import uz.pdp.springboot.springboot.services.UrlCreateDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UrlMapper {
    Url toEntity(UrlCreateDTO urlCreateDTO);
}