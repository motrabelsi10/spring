package tn.esprit.espritgather.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.Task;
import tn.esprit.espritgather.repo.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {
    TaskRepository taskRepository;

    public List<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }

    public Task retrieveTask(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public Task addTask(Task c) {
        return taskRepository.save(c);
    }

    public void removeTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task modifyTask(Task task) {
        return taskRepository.save(task);
    }

}