package com.nhnacademy.gatewayserver.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {
    private String projectName;
    private String userName;
    private String createdMemberId;
}
