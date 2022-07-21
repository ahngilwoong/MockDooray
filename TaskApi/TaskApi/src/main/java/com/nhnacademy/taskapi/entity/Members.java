package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num", nullable = false)
    private Long memberNum;
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects project;

    private String memberId;
    private String memberName;
}
