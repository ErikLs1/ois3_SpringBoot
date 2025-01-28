package com.ois3.service;

import com.ois3.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto dto);

    TaskDto updateTask(Integer id, TaskDto dto);

    TaskDto getTaskById(Integer id);

    List<TaskDto> getAllTasks();

    void deleteTask(Integer id);
}
