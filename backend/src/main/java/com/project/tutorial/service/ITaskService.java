package com.project.tutorial.service;

import com.project.tutorial.DTO.TaskDTO;
import com.project.tutorial.model.Task;

import java.util.List;

public interface ITaskService {
    Task getTaskById(Long id);
    List<Task> getAllTasksByTaskListId(Long id);
    Task createTask(TaskDTO taskDTO);
    Task updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
}
