package uz.pdp.springboot.springboot.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link ProjectColumn} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectColumnDto implements Serializable {
    private String name;
    private Integer order;
}