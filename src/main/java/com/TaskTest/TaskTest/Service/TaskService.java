package com.TaskTest.TaskTest.Service;

import com.TaskTest.TaskTest.Model.Task;
import com.TaskTest.TaskTest.Repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return (List<Task>) taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseGet(Task::new);
    }

    public boolean addTask(Task task) {
        taskRepository.save(task);
        return taskRepository.existsById(task.getId());
    }

    public boolean updateTask(long id, Task task) {
        Task oldTask = taskRepository.findById(id).get();
        oldTask.setNameTask(task.getNameTask());
        oldTask.setTask(task.getTask());
        taskRepository.save(oldTask);
        return !oldTask.equals(getTaskById(id));
    }

    public boolean removeTaskById(long id) {
        taskRepository.delete(getTaskById(id));
        return !taskRepository.existsById(id);
    }
}
