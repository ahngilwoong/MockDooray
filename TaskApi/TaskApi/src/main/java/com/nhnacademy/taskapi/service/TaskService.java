package com.nhnacademy.taskapi.service;

import com.nhnacademy.taskapi.request.TaskRequest;
import com.nhnacademy.taskapi.response.TaskResponse;

import java.util.List;

public interface TaskService {
    void createTask(TaskRequest request);
    void modifyTask(TaskRequest request);
    void deleteTask(Long taskNum);
    List<TaskResponse> findTaskList(Long projectNum);
    TaskResponse findTask(Long taskNum);
}
