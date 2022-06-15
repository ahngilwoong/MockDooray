package com.nhnacademy.taskapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_num", nullable = false)
    private Long commentNum;
    @ManyToOne
    @JoinColumn(name = "task_num")
    private Tasks taskNum;
    private String commentContent;
    private String commentWriter;
}
