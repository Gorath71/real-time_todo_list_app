package com.project.tutorial.service;

import com.project.tutorial.DTO.TaskDTO;
import com.project.tutorial.model.Task;
import com.project.tutorial.model.TaskList;
import com.project.tutorial.repository.TaskListRepository;
import com.project.tutorial.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class TaskService implements ITaskService{
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskService(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));
    }

    @Override
    public List<Task> getAllTasksByTaskListId(Long id) {
        if (!taskListRepository.existsById(id))
            throw new EntityNotFoundException("Task list with id " + id + " not found");
        return taskRepository.findByTaskListId(id);
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        TaskList taskList = taskListRepository.findById(taskDTO.getTaskListId()).orElseThrow(() -> new EntityNotFoundException("Task list with id " + taskDTO.getTaskListId() + " not found"));

        Task task = new Task();
        task.setId(null);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(false);
        task.setTaskList(taskList);

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task task = getTaskById(id);

        TaskList taskList = taskListRepository.findById(taskDTO.getTaskListId()).orElseThrow(() -> new EntityNotFoundException("Task list with id " + taskDTO.getTaskListId() + " not found"));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(false);
        task.setTaskList(taskList);

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
