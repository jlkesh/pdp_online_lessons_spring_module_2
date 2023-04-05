package uz.pdp.springboot.springboot.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Project} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO implements Serializable {
    private String name;
    @Size(message = "Project code length must be between  {min} and {max}", min = 4, max = 30)
    @NotBlank(message = "Project Column Can not be blank")
    private String code;
    private List<ProjectColumnDto> projectColumns = new ArrayList<>();
}