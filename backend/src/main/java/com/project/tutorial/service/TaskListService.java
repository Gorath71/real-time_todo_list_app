package com.project.tutorial.service;

import com.project.tutorial.DTO.TaskListDTO;
import com.project.tutorial.model.TaskList;
import com.project.tutorial.repository.TaskListRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListService implements ITaskListService{
    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public TaskList getTaskListById(Long id) {
        Optional<TaskList> taskListOptional = taskListRepository.findById(id);
        return taskListOptional.orElseThrow(()-> new EntityNotFoundException("TaskList with id " + id + " not found"));
    }

    @Override
    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskListDTO taskListDTO) {
        TaskList taskList = new TaskList();
        taskList.setId(null);
        taskList.setName(taskListDTO.getName());
        taskList.setTasks(null);

        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList updateTaskList(Long id, TaskListDTO taskListDTO) {
        if (!taskListRepository.existsById(id))
            throw new EntityNotFoundException("Task list with id " + id + " not found");

        TaskList taskList = new TaskList();
        taskList.setId(id);
        taskList.setName(taskListDTO.getName());
        taskList.setTasks(null);

        return taskListRepository.save(taskList);
    }

    @Override
    public void deleteTaskList(Long id) {
        if (!taskListRepository.existsById(id))
            throw new EntityNotFoundException("Task list with id " + id + " not found");
        taskListRepository.deleteById(id);
    }
}
