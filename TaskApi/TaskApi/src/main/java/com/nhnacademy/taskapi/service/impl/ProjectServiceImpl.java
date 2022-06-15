package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.entity.Members;
import com.nhnacademy.taskapi.entity.MembersPk;
import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.repository.MemberRepository;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.request.ProjectRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    @Override
    public void modifyProjectStatus(Long projectNum, String status) {
        Optional<Projects> projectResponse = projectRepository.findById(projectNum);
        projectResponse.get().setProjectStatus(status);
        projectRepository.save(projectResponse.get());
    }

    @Override
    public ProjectResponse findProject(Long projectNum) {
        Optional<ProjectResponse> projectResponse = projectRepository.findByProjectNum(projectNum);
        return projectResponse.get();
    }

    @Override
    public Projects findNoDtoProjectEntityForUpdate(Long projectNum) {
        Optional<Projects> projects = projectRepository.findById(projectNum);
        return projects.get();
    }

    @Override
    public void createProject(ProjectRequest projectRequest) {
        Projects projects = projectRepository.save(
                Projects.builder()
                        .projectName(projectRequest.getProjectName())
                        .projectStatus("활성")
                        .adminNum(1L)
                        .build()
        );
        memberRepository.save(
                Members.builder()
                        .memberPk(new MembersPk(1L,projects))
                        .memberId(projectRequest.getCreatedMemberId())
                        .memberName(projectRequest.getUserName())
                        .build());
    }
}
