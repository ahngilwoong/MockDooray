package com.nhnacademy.taskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "milestones")
public class Milestones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_num", nullable = false)
    private Long milestoneNum;
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects projectNum;
    private String milestone_name;
    private LocalDate start_date;
    private LocalDate end_date;
}
