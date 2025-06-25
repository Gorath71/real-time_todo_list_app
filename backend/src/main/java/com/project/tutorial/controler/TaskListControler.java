package com.project.tutorial.controler;

import com.project.tutorial.DTO.TaskListDTO;
import com.project.tutorial.model.TaskList;
import com.project.tutorial.service.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasklist")
public class TaskListControler {
    private final TaskListService taskListService;

    public TaskListControler(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskList> getTaskList(@PathVariable Long id) {
        TaskList taskList = taskListService.getTaskListById(id);
        if (taskList == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskList);
    }

    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskList() {
        List<TaskList> taskLists = taskListService.getAllTaskLists();
        return ResponseEntity.ok(taskLists);
    }

    @PostMapping
    public ResponseEntity<TaskList> createTaskList(@RequestBody TaskListDTO taskListDTO) {
        TaskList taskList = taskListService.createTaskList(taskListDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskList> updateTaskList(@RequestBody TaskListDTO taskListDTO, @PathVariable Long id) {
        TaskList taskList = taskListService.updateTaskList(id, taskListDTO);
        if (taskList == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskList> deleteTaskList(@PathVariable Long id) {
        taskListService.deleteTaskList(id);
        return ResponseEntity.ok().build();
    }
}
