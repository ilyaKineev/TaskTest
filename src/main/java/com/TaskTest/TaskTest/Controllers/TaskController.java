package com.TaskTest.TaskTest.Controllers;


import com.TaskTest.TaskTest.Model.Task;
import com.TaskTest.TaskTest.Service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public String home() {
        return "Hello!";
    }

    @GetMapping(value = "/task")
    public ResponseEntity<List<Task>> get() {
        final List<Task> tasks = taskService.getAllTask();
        return tasks != null && !tasks.isEmpty()
                ? new ResponseEntity<>(tasks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Task> get(@PathVariable(name = "id") long id) {
        final Task task = taskService.getTaskById(id);
        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/task")
    public ResponseEntity<?> add(@RequestBody Task task) {
        final boolean answer = taskService.addTask(task);
        return answer != false
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/task/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Task task) {
        boolean answer = taskService.updateTask(id,task);
        return answer != false
                ? new ResponseEntity<>(HttpStatus.UPGRADE_REQUIRED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity<?> remove(@PathVariable(name = "id") long id) {
        boolean answer = taskService.removeTaskById(id);
        return answer != false
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
