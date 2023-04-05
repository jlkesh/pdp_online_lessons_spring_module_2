package uz.pdp.springboot.springboot.auditing;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @DeleteMapping
    public void deleteAll() {
        todoRepository.deleteAll();
    }

}
