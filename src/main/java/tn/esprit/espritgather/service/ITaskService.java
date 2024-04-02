package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Task;

import java.util.List;
public interface ITaskService {
    public List<Task> retrieveAllTasks();
    public Task retrieveTask(Long idTask);
    public Task addTask(Task c);
    public void removeTask(Long idTask);
    public Task modifyTask(Task task);
}