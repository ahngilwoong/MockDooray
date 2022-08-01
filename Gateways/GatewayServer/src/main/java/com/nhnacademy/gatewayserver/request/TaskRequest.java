package com.nhnacademy.gatewayserver.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TaskRequest {
    private Long taskNum;
    private Long projectNum;
    private Long milestoneNum;
    private String taskName;
    private String taskContent;
    private String taskWriter;
    private String chargePerson;
}
