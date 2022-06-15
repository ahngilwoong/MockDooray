package com.nhnacademy.taskapi.request;


import com.nhnacademy.taskapi.entity.Projects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberRequest {
    private Long memberNum;
    private Long projectNum;
    private String memberId;
    private String memberName;
}
