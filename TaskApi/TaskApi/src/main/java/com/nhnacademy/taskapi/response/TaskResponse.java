package com.nhnacademy.taskapi.response;


import com.nhnacademy.taskapi.entity.Tasks;
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

    public TaskResponse(Tasks tasks) {
        this.taskNum = tasks.getTaskNum();
        this.projectNum = tasks.getProjectNum().getProjectNum();
        this.milestoneNum = tasks.getMilestoneNum().getMilestoneNum();
        this.taskName = tasks.getTaskName();
        this.taskContent = tasks.getTaskContent();
        this.taskWriter = tasks.getTaskWriter();
        this.chargePerson = tasks.getChargePerson();
    }
}
