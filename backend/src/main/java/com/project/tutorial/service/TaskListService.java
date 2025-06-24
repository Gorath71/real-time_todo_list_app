package com.project.tutorial.service;

import com.project.tutorial.model.TaskList;
import com.project.tutorial.repository.TaskListRepository;
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
        return taskListOptional.orElse(null);
    }

    @Override
    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (taskList.getId() != null)
            return null;
        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList updateTaskList(Long id, TaskList taskList) {
        if (taskList.getId() != null)
            return null;
        if (!taskListRepository.existsById(id))
            return null;
        return taskListRepository.save(taskList);
    }

    @Override
    public void deleteTaskList(Long id) {
        taskListRepository.deleteById(id);
    }
}
