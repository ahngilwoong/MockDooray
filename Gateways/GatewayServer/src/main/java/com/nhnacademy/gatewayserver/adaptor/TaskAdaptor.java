package com.nhnacademy.gatewayserver.adaptor;

import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.TaskResponse;

import java.util.List;

public interface TaskAdaptor {
    List<TaskResponse> findProjectInTasks(Long taskNum);
    void addTask(TaskRequest taskRequest);
    void modifyTask(TaskRequest taskRequest);
    void deleteTask(Long taskNum);
    TaskResponse findTask(Long taskNum);
}
