package uz.pdp.mapstruct.projectColumn;

import lombok.*;

import java.nio.file.Path;
import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ProjectColumn {
    private String id;
    private String name;
    private Integer order;
    private LocalDateTime createdAt;
}
