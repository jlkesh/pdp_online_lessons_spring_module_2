package uz.pdp.mapstruct.projectColumn;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ProjectColumnDTO {
    private String pc_name;
    private String pc_order;
    private String pc_createdAt;
}
