package com.nhnacademy.gatewayserver.service.impl;

import com.nhnacademy.gatewayserver.adaptor.TaskAdaptor;
import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.TaskResponse;
import com.nhnacademy.gatewayserver.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskAdaptor taskAdaptor;

    @Override
    public List<TaskResponse> findTaskList(Long projectNum) {
        return taskAdaptor.findTasks(projectNum);
    }

    @Override
    public void addTask(TaskRequest taskRequest) {
        taskAdaptor.addTask(taskRequest);
    }

    @Override
    public void modifyTask(TaskRequest taskRequest) {
        taskAdaptor.modifyTask(taskRequest);
    }

    @Override
    public void deleteTask(Long taskNum, Long projectNum) {
        taskAdaptor.deleteTask(taskNum, projectNum);
    }

    @Override
    public TaskResponse findTask(Long projectNum, Long taskNum) {
        return taskAdaptor.findTask(projectNum, taskNum);
    }
}
