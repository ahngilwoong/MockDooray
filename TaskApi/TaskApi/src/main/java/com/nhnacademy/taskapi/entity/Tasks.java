package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_num", nullable = false)
    private Long taskNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects project;

    @OneToOne
    @JoinColumn(name = "milestone_num")
    private Milestones milestoneNum;
    private String taskName;
    private String taskContent;
    private String taskWriter;
    private String chargePerson;
}
