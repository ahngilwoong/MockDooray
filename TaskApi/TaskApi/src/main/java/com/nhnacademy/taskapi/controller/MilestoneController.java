package com.nhnacademy.taskapi.controller;

import com.nhnacademy.taskapi.response.MilestoneResponse;
import com.nhnacademy.taskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock-dooray/projects")
public class MilestoneController {
    private final MilestoneService milestoneService;

    @GetMapping("/create-milestone")
    public ResponseEntity<MilestoneResponse> addMilestoneInProject(){
        return null;
    }
}
