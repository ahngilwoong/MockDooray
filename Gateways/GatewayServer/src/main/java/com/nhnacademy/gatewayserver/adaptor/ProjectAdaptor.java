package com.nhnacademy.gatewayserver.adaptor;

import com.nhnacademy.gatewayserver.request.ProjectRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;

import java.util.List;

public interface ProjectAdaptor {
     List<ProjectResponse> findProjectListByMemberId(String memberId);
     void createProject(ProjectRequest projectRequest);
     void updateProjectStatus(Long projectNum, String status);
     ProjectResponse projectDetail(Long projectNum);
}
