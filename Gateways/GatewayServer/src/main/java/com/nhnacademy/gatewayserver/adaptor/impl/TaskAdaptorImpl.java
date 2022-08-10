package com.nhnacademy.gatewayserver.adaptor.impl;

import com.nhnacademy.gatewayserver.adaptor.TaskAdaptor;
import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;
import com.nhnacademy.gatewayserver.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor {

    private final RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    @Override
    public List<TaskResponse> findTasks(Long projectNum) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TaskResponse>>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?projectNum=" + projectNum
                , HttpMethod.GET
                , request
                , new ParameterizedTypeReference<List<TaskResponse>>() {});
        return response.getBody();
    }

    @Override
    public void addTask(TaskRequest taskRequest) {

        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TaskRequest> entity = new HttpEntity<>(taskRequest,httpHeaders);

        ResponseEntity<Void>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?projectNum="
                        + taskRequest.getProjectNum()
                        + "tasks/create"
                , HttpMethod.POST
                , entity
                , Void.class);
    }

    @Override
    public void modifyTask(TaskRequest taskRequest) {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TaskRequest> entity = new HttpEntity<>(taskRequest,httpHeaders);

        ResponseEntity<Void>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?projectNum="
                        + taskRequest.getProjectNum()
                        + "tasks/?taskNum="
                        + taskRequest.getTaskNum()
                        + "/modify"
                , HttpMethod.POST
                , entity
                , Void.class);
    }

    @Override
    public void deleteTask(Long taskNum, Long projectNum) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Void>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?projectNum="
                        + projectNum
                        + "tasks/?taskNum="
                        + taskNum
                        + "/delete"
                , HttpMethod.GET
                , request
                , Void.class);
    }

    @Override
    public TaskResponse findTask(Long projectNum, Long taskNum) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<TaskResponse>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?projectNum="
                        + projectNum
                        + "tasks/?taskNum="
                        + taskNum
                , HttpMethod.GET
                , request
                , TaskResponse.class);
        return response.getBody();
    }
}
