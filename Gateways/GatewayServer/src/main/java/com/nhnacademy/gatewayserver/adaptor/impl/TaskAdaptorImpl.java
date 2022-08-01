package com.nhnacademy.gatewayserver.adaptor.impl;

import com.nhnacademy.gatewayserver.adaptor.TaskAdaptor;
import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.TaskResponse;

import java.util.List;

public class TaskAdaptorImpl implements TaskAdaptor {
    @Override
    public List<TaskResponse> findProjectInTasks(Long taskNum) {
        return null;
    }

    @Override
    public void addTask(TaskRequest taskRequest) {

    }

    @Override
    public void modifyTask(TaskRequest taskRequest) {

    }

    @Override
    public void deleteTask(Long taskNum) {

    }

    @Override
    public TaskResponse findTask(Long taskNum) {
        return null;
    }
}
