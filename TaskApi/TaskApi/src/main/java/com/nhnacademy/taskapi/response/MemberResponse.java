package com.nhnacademy.taskapi.response;

import com.nhnacademy.taskapi.entity.MembersPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberResponse {
    private MembersPk memberPk;
    private String memberId;
    private String memberName;
}
