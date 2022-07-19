package com.nhnacademy.taskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_num", nullable = false)
    private Long tagNum;
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects project;
    private String tagName;

}
