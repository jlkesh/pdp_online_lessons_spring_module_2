package uz.pdp.springboot.springboot.project;

import org.mapstruct.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectDTO projectDTO);

    ProjectDTO toDto(Project project);

    List<ProjectDTO> toDto(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDTO projectDTO, @MappingTarget Project project);

    Project fromCreateDTO(ProjectCreateDTO projectCreateDTO);

}