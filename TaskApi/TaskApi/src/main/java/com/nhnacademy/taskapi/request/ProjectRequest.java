package com.nhnacademy.taskapi.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProjectRequest {
    private String projectName;
    private String createdMemberId;
    private String userName;
}
