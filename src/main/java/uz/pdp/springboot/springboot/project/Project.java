package uz.pdp.springboot.springboot.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "uc_project_code", columnNames = {"code"})
})
@NamedQueries({
        @NamedQuery(name = "Project.findByNameIgnoreCaseOrderByIdDesc", query = "select p from Project p where upper(p.name) = upper(:name) order by p.id DESC")
})
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Size(message = "Project code length must be between  {min} and {max}", min = 4, max = 30)
    @NotBlank(message = "Project Column Can not be blank")
    @Column(updatable = false, nullable = false)
    private String code;

    @OneToMany(mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ProjectColumn> projectColumns = new ArrayList<>();

}
