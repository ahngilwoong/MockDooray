package com.nhnacademy.taskapi.controller;


import com.nhnacademy.taskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.response.TaskResponse;
import com.nhnacademy.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mockdooray/projects")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{projectNum}/tasks")
    public List<TaskResponse> taskList(@PathVariable Long projectNum){
        List<TaskResponse>  tasks = taskService.findTaskList(projectNum);
        return tasks;
    }

}
