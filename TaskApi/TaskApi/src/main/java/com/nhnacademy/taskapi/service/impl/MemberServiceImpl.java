package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.entity.Members;
import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.repository.MemberRepository;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.request.MemberRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectResponse> findMemberProject(String memberId) {
        List<Projects> projectsList = memberRepository.findProjectByMemberId(memberId);
        return projectsList.stream().map(projects -> new ProjectResponse(projects)).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void addProjectMember(MemberRequest memberRequest) {
        memberRepository.save(
                Members.builder()
                        .project(projectRepository.findById(memberRequest.getProjectNum()).get())
                        .memberId(memberRequest.getMemberId())
                        .memberName(memberRequest.getMemberName())
                        .build()
        );
    }

}
