package com.nhnacademy.gatewayserver.controller;

import com.nhnacademy.gatewayserver.request.ProjectRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;
import com.nhnacademy.gatewayserver.service.ProjectService;
import com.nhnacademy.gatewayserver.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mock-dooray")
public class ProjectController {
    private final ProjectService projectService;
    private final RedisTemplate<String,String> redisTemplate;
    private final RegisterService registerService;

    @GetMapping("/projects")
    public String showMemberProjectList(HttpServletRequest httpServletRequest, Model model){
        String id = (String) redisTemplate.opsForHash().get(httpServletRequest.getSession().getId(),"username");
        List<ProjectResponse> projectResponses = projectService.findMemberBelongProject(id);
        model.addAttribute("list",projectResponses);
        return "mock-dooray";
    }

    @PostMapping("/add-project")
    public String postCreateProject(@ModelAttribute ProjectRequest projectRequest, HttpServletRequest httpServletRequest){
        String memberId = (String) redisTemplate.opsForHash().get(httpServletRequest.getSession().getId(),"username");
        projectService.createProject(projectRequest, memberId);
        return "redirect:/mock-dooray";
    }

    @GetMapping("/add-project")
    public String getCreateProject(){

        return "add-project";
    }

    @GetMapping("/projects/{projectNum}")
    public String projectDetail(@PathVariable Long projectNum, Model model){
        ProjectResponse projectResponse = projectService.findProject(projectNum);
        model.addAttribute("project",projectResponse);
        return null;
    }

//    @GetMapping("/projects/{projectNum}")
//    public String showProjectDetail(@PathVariable Long projectNum, Model model){
//        ProjectResponse projectResponse = projectService.findProject(projectNum);
//        model.addAttribute("project",projectResponse);
//        return
//    }


}
