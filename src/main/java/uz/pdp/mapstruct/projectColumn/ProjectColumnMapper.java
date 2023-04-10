package uz.pdp.mapstruct.projectColumn;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProjectColumnMapper {
    @Mapping(target = "pc_name", source = "name")
    @Mapping(target = "pc_order", source = "order")
    @Mapping(target = "pc_createdAt", source = "createdAt",dateFormat = "dd-MM-YYYY")
    ProjectColumnDTO toDto(ProjectColumn projectColumn);
}
