package com.nhnacademy.taskapi.controller;


import com.nhnacademy.taskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.request.TaskRequest;
import com.nhnacademy.taskapi.response.ProjectResponse;
import com.nhnacademy.taskapi.response.TaskResponse;
import com.nhnacademy.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock-dooray/projects")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{projectNum}/tasks")
    public List<TaskResponse> findProjectInTask(@PathVariable Long projectNum){
        List<TaskResponse> tasks = taskService.findTaskList(projectNum);
        return tasks;
    }

    @GetMapping("/{projectNum}/tasks/{taskNum}/delete")
    public void deleteTask(@PathVariable Long taskNum){
        taskService.deleteTask(taskNum);
    }


    @PostMapping("/{projectNum}/tasks/create")
    public void addTask(@RequestBody TaskRequest taskRequest){
        taskService.createTask(taskRequest);
    }

    @PostMapping("/{projectNum}/tasks/modify")
    public void modifyTask(@RequestBody TaskRequest taskRequest){
        taskService.modifyTask(taskRequest);
    }

    @GetMapping("/{projectNum}/tasks/{taskNum}")
    public TaskResponse findTask(@PathVariable Long taskNum){
        return taskService.findTask(taskNum);
    }
}
