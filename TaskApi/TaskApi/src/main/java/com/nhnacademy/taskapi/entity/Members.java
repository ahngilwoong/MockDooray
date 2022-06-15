package com.nhnacademy.taskapi.entity;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Members {
    @EmbeddedId
    private MembersPk memberPk;
    private String memberId;
    private String memberName;
}
