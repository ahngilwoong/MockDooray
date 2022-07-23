package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "milestones")
public class Milestones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_num", nullable = false)
    private Long milestoneNum;
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects project;
    private String milestoneName;
    private LocalDate startDate;
    private LocalDate endDate;

}
