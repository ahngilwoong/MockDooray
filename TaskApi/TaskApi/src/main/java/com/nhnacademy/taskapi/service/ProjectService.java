package com.nhnacademy.taskapi.service;

import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.request.ProjectRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;


public interface ProjectService {
    void modifyProjectStatus(Long projectNum, String status);

    ProjectResponse findProject(Long projectNum);
    Projects findNoDtoProjectEntityForUpdate(Long projectNum);

    void createProject(ProjectRequest projectRequest);
}
