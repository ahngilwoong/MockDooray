package com.nhnacademy.taskapi.response;


import com.nhnacademy.taskapi.entity.Projects;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectResponse {

    private Long projectNum;
    private String projectName;
    private String projectStatus;
    private Long adminNum;

    public ProjectResponse(Projects projects) {
        this.projectNum = projects.getProjectNum();
        this.projectName = projects.getProjectName();
        this.projectStatus = projects.getProjectStatus();
        this.adminNum = projects.getAdminNum();
    }
}

