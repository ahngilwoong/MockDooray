package com.nhnacademy.gatewayserver.service;

import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> findTaskList(Long projectNum);
    void addTask(TaskRequest taskRequest);
    void modifyTask(TaskRequest taskRequest);
    void deleteTask(Long taskNum, Long projectNum);
    TaskResponse findTask(Long projectNum, Long taskNum);


}
