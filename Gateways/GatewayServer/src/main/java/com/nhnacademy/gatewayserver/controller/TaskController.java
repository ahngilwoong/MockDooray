package com.nhnacademy.gatewayserver.controller;


import com.nhnacademy.gatewayserver.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mock-dooray/projects/{projectNum}/tasks")
public class TaskController {
    private final TaskService taskService;
}
