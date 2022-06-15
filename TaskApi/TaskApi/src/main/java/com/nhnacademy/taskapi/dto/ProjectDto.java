package com.nhnacademy.taskapi.dto;


import lombok.*;

@Getter
@Setter
public class ProjectDto {
    private Long projectNum;
    private String projectName;
    private String projectStatus;
    private Long adminNum;
}
