package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_num", nullable = false)
    private Long projectNum;
    private String projectName;
    private String projectStatus;
    private Long adminNum;
}
