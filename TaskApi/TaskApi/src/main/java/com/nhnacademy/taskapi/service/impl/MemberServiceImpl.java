package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.dto.ProjectDto;
import com.nhnacademy.taskapi.entity.Members;
import com.nhnacademy.taskapi.entity.MembersPk;
import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.repository.MemberRepository;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.request.MemberRequest;
import com.nhnacademy.taskapi.response.MemberResponse;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.response.TaskResponse;
import com.nhnacademy.taskapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectResponse> findMemberProject(Long memberNum) {
        List<Projects> projectsList = memberRepository.findProjectByMemberNum(memberNum);
        return projectsList.stream().map(projects -> new ProjectResponse(projects)).collect(Collectors.toList());

    }

    @Override
    public void addProjectMember(MemberRequest memberRequest) {
        memberRepository.save(
                Members.builder()
                        .memberPk(new MembersPk(memberRequest.getMemberNum(), projectRepository.findById(memberRequest.getProjectNum()).get()))
                        .memberId(memberRequest.getMemberId())
                        .memberName(memberRequest.getMemberName())
                        .build()
        );
    }

    @Override
    public Long findMemberNumByMemberId(String memberId) {
        return memberRepository.findMemberNumByMemberId(memberId);
    }
}
