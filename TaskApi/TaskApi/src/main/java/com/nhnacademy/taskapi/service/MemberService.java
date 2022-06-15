package com.nhnacademy.taskapi.service;




import com.nhnacademy.taskapi.request.MemberRequest;
import com.nhnacademy.taskapi.response.MemberResponse;
import com.nhnacademy.taskapi.response.ProjectResponse;

import java.util.List;


public interface MemberService {
    List<ProjectResponse> findMemberProject(Long MemberNum);
    void addProjectMember(MemberRequest memberRequest);
    Long findMemberNumByMemberId(String memberId);
}
