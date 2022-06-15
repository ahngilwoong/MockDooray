package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.request.ProjectRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @InjectMocks
    private ProjectServiceImpl projectService;
    @Mock
    private ProjectRepository projectRepository;
    private Projects projects;
    private ProjectResponse projectResponse;
    private ProjectRequest projectRequest;

    @BeforeEach
    void setUp(){
        projects = new Projects(1L,"김해 웹서비스 개발 1기","활성",1L);
        projectResponse = new ProjectResponse(1L,"김해 웹서비스 개발 1기","활성",1L);
        projectRequest = new ProjectRequest("김해 웹서비스 개발 0기", "dksrlfdnd1", "안길웅");
    }

    @Test
    @DisplayName("이미 존재하는 프로젝트의 상태 수정 단위 테스트")
    void modifyProjectStatusTest(){
        when(projectRepository.findById(anyLong())).thenReturn(Optional.ofNullable(projects));
        projects.setProjectStatus("휴면");
        when(projectRepository.save(any(Projects.class))).thenReturn(projects);
        Projects projects = projectRepository.findById(1L).get();
        projects.setProjectStatus("휴면");
        projectRepository.save(projects);
        projectService.modifyProjectStatus(1L,"휴면");
        verify(projectRepository, atLeast(1)).findById(1L);
        verify(projectRepository, atLeast(1)).save(projects);
    }

    @Test
    @DisplayName("하나의 프로젝트 단건 조회 단위 테스트")
    void findProjectTest(){
        when(projectRepository.findByProjectNum(anyLong())).thenReturn(Optional.ofNullable(projectResponse));
        ProjectResponse projectResponse = projectService.findProject(1L);
        assertThat(projectResponse.getProjectNum()).isEqualTo(1L);
        assertThat(projectResponse.getProjectName()).isEqualTo("김해 웹서비스 개발 1기");
        assertThat(projectResponse.getProjectStatus()).isEqualTo("활성");
        verify(projectRepository, atLeast(1)).findByProjectNum(1L);
    }

    @Test
    @DisplayName("프로젝트 등록 단위 테스트")
    void createProjectTest(){

    }

}