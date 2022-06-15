package com.nhnacademy.gatewayserver.response;


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

}

