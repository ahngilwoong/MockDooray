package com.nhnacademy.gatewayserver.adaptor.impl;

import com.nhnacademy.gatewayserver.adaptor.ProjectAdaptor;
import com.nhnacademy.gatewayserver.request.MemberRequest;
import com.nhnacademy.gatewayserver.request.ProjectRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ProjectAdaptorImpl implements ProjectAdaptor {
    private final RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    @Override
    public List<ProjectResponse> findProjectListByMemberId(String memberId) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectResponse>>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects?memberId=" + memberId, HttpMethod.GET, request, new ParameterizedTypeReference<List<ProjectResponse>>() {});
        return response.getBody();
    }

    @Override
    public void createProject(ProjectRequest projectRequest) {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjectRequest> entity = new HttpEntity<>(projectRequest,httpHeaders);
        restTemplate.exchange("http://localhost:1004/mock-dooray/create-project", HttpMethod.POST, entity, Void.class);
    }

    @Override
    public void updateProjectStatus(Long projectNum, String status) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        restTemplate.exchange("http://localhost:1004/mock-dooray/projects/modify-status/"+projectNum+"?status="+status, HttpMethod.GET, request, Void.class);

    }

    @Override
    public ProjectResponse projectDetail(Long projectNum) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectResponse>
                response = restTemplate.exchange("http://localhost:1004/mock-dooray/projects/" + projectNum, HttpMethod.GET, request, ProjectResponse.class);
        return response.getBody();
    }
}
