package com.nhnacademy.taskapi.request;

import com.nhnacademy.taskapi.entity.Milestones;
import com.nhnacademy.taskapi.entity.Projects;
import lombok.*;
import org.springframework.scheduling.config.Task;

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
