package com.project.tutorial.service;

import com.project.tutorial.DTO.TaskListDTO;
import com.project.tutorial.model.TaskList;

import java.util.List;

public interface ITaskListService {
    TaskList getTaskListById(Long id);
    List<TaskList> getAllTaskLists();
    TaskList createTaskList(TaskListDTO taskListDTO);
    TaskList updateTaskList(Long id, TaskListDTO taskListDTO);
    void deleteTaskList(Long id);
}
