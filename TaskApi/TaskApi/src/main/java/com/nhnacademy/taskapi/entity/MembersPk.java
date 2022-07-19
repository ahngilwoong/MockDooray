package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class MembersPk implements Serializable {
    @Column(name = "member_num")
    private Long memberNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Projects project;
}
