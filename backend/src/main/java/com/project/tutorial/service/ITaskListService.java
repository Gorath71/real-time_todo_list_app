package com.project.tutorial.service;

import com.project.tutorial.model.TaskList;

import java.util.List;

public interface ITaskListService {
    TaskList getTaskListById(Long id);
    List<TaskList> getAllTaskLists();
    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(Long id, TaskList taskList);
    void deleteTaskList(Long id);
}
