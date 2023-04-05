package uz.pdp.springboot.springboot.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Project} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreateDTO implements Serializable {
    private String name;
}