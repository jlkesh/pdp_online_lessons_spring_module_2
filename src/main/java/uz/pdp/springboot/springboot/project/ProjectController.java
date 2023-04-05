package uz.pdp.springboot.springboot.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository,
                             ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<ProjectDTO> getAllProject() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toDto(projects);
    }

    @PostMapping
    public Project create(@RequestBody ProjectCreateDTO dto) {
        Project project = projectMapper.fromCreateDTO(dto);
        project.setCode(dto.getName().replace(" ", "_").toUpperCase());
        projectRepository.save(project);
        return project;
    }
}
