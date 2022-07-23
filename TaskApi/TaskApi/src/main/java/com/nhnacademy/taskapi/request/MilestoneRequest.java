package com.nhnacademy.taskapi.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MilestoneRequest {
    private Long projectNum;
    private String milestoneName;
    private LocalDate startDate;
    private LocalDate endDate;
}
