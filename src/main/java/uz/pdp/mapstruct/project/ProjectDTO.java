package uz.pdp.mapstruct.project;

import lombok.*;
import uz.pdp.mapstruct.projectColumn.ProjectColumn;
import uz.pdp.mapstruct.projectColumn.ProjectColumnDTO;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ProjectDTO {
    private String id;
    private String name;
    private String documentPath;
    private List<ProjectColumnDTO> projectColumns;
    private String createdAt;
}
