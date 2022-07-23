package com.nhnacademy.taskapi.response;

import com.nhnacademy.taskapi.entity.Milestones;
import com.nhnacademy.taskapi.entity.Projects;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MilestoneResponse {
    private Long milestoneNum;
    private Projects project;
    private String milestoneName;
    private LocalDate startDate;
    private LocalDate endDate;

    public MilestoneResponse(Milestones milestones) {
        this.milestoneNum = milestones.getMilestoneNum();
        this.project = milestones.getProject();
        this.milestoneName = milestones.getMilestoneName();
        this.startDate = milestones.getStartDate();
        this.endDate = milestones.getEndDate();
    }
}
