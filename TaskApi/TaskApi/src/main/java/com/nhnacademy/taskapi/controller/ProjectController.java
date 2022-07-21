package com.nhnacademy.taskapi.controller;

import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.request.ProjectRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.service.MemberService;
import com.nhnacademy.taskapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock-dooray")
public class ProjectController {
    private final MemberService memberService;
    private final ProjectService projectService;

    @GetMapping("/projects")
    public List<ProjectResponse> projectsList(@RequestParam String memberId){
        List<ProjectResponse> projects = memberService.findMemberProject(memberId);
        return projects;
    }

    @GetMapping("/projects/{projectNum}")
    public ProjectResponse projectDetail(@PathVariable Long projectNum){
        ProjectResponse projectResponse = projectService.findProject(projectNum);
        return projectResponse;
    }

    @PostMapping("/create-project")
    public void projectAdd(@RequestBody ProjectRequest projectRequest){
        projectService.createProject(projectRequest);
    }

    @GetMapping("/projects/modify-status/{projectNum}")
    public void projectStatusModify(@PathVariable Long projectNum, @RequestParam String status){
        projectService.modifyProjectStatus(projectNum,status);
    }

}

