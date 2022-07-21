package com.nhnacademy.gatewayserver.service.impl;

import com.nhnacademy.gatewayserver.adaptor.AccountAdaptor;
import com.nhnacademy.gatewayserver.adaptor.MemberAdaptor;
import com.nhnacademy.gatewayserver.adaptor.ProjectAdaptor;
import com.nhnacademy.gatewayserver.request.MemberRequest;
import com.nhnacademy.gatewayserver.request.ProjectRequest;
import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.MemberResponse;
import com.nhnacademy.gatewayserver.response.ProjectResponse;
import com.nhnacademy.gatewayserver.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;
    private final MemberAdaptor memberAdaptor;
    private final AccountAdaptor accountAdaptor;

    @Override
    public void modifyProjectStatus(Long projectNum, String status) {
        projectAdaptor.updateProjectStatus(projectNum,status);
    }

    @Override
    public ProjectResponse findProject(Long projectNum) {
        return projectAdaptor.projectDetail(projectNum);
    }

    @Override
    public List<ProjectResponse> findMemberBelongProject(String memberId) {
        List<ProjectResponse> responseList = projectAdaptor.findProjectListByMemberId(memberId);
        return responseList;
    }

    @Override
    public void createProject(ProjectRequest projectRequest, String memberId) {
        Long createProjectMemberNum = accountAdaptor.getUserIdByUserNum(memberId);
        projectRequest.setCreatedMemberId(memberId);
        projectAdaptor.createProject(projectRequest);
    }
}
