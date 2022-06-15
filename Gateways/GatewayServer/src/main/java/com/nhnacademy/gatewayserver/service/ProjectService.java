package com.nhnacademy.gatewayserver.service;

import com.nhnacademy.gatewayserver.request.MemberRequest;
import com.nhnacademy.gatewayserver.request.ProjectRequest;
import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    void modifyProjectStatus(Long projectNum, String status);

    ProjectResponse findProject(Long projectNum);

    List<ProjectResponse> findMemberBelongProject(String memberId);

    void createProject(ProjectRequest projectRequest);
}
