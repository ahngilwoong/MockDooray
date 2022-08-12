package com.nhnacademy.gatewayserver.controller;


import com.nhnacademy.gatewayserver.request.TaskRequest;
import com.nhnacademy.gatewayserver.response.ProjectResponse;
import com.nhnacademy.gatewayserver.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mock-dooray/projects/{projectNum}")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String showProjectTasks(@PathVariable Long projectNum){
        //model
        taskService.findTaskList(projectNum);
        return "task-list";
    }

    @PostMapping("/add-task")
    public String postCreateTask(TaskRequest taskRequest){
        taskService.addTask(taskRequest);
        return "redirect:/mock-dooray/projects/"+taskRequest.getProjectNum()+"/tasks";
    }

    @GetMapping("/add-task")
    public String getCreateTask(@PathVariable Long projectNum){
        return "add-task";
    }

    @GetMapping("/tasks/{taskNum}")
    public String taskDetail(@PathVariable Long taskNum, Model model){
        //model
        return null;
    }
    
}
