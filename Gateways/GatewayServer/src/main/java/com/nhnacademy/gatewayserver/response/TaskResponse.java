package com.nhnacademy.gatewayserver.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class TaskResponse {
    private Long taskNum;
    private Long projectNum;
    private Long milestoneNum;
    private String taskName;
    private String taskContent;
    private String taskWriter;
    private String chargePerson;


}
