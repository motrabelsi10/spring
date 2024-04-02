package tn.esprit.espritgather.control;
import tn.esprit.espritgather.entity.Volunteer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Task;
import tn.esprit.espritgather.service.ITaskService;

import java.util.List;

@Tag(name = "Gestion Task")
@RestController
@AllArgsConstructor
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskRestController {
    ITaskService taskService;
    // http://localhost:8089/espritgather/task/retrieve-all-tasks
    @Operation(description = "récupérer toutes les task de la base de données")
    @GetMapping("/retrieve-all-tasks")
    public List<Task> gettasks() {
        List<Task> listTasks = taskService.retrieveAllTasks();
        return listTasks;
    }
    // http://localhost:8089/espritgather/task/retrieve-task/8
    @GetMapping("/retrieve-task/{task-id}")
    public Task retrievetask(@PathVariable("task-id") Long chId) {
        Task task = taskService.retrieveTask(chId);
        return task;
    }
    // http://localhost:8089/espritgather/task/add-task
    @PostMapping("/add-task")
    public Task addtask(@RequestBody Task c) {
        Task task = taskService.addTask(c);
        return task;
    }
    // http://localhost:8089/espritgather/task/remove-task/{task-id}
    @DeleteMapping("/remove-task/{task-id}")
    public void removetask(@PathVariable("task-id") Long chId) {
        taskService.removeTask(chId);
    }
    // http://localhost:8089/espritgather/task/modify-task
    @PutMapping("/modify-task")
    public Task modifytask(@RequestBody Task c) {
        Task task = taskService.modifyTask(c);
        return task;
    }


}