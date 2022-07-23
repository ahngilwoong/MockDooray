package com.nhnacademy.taskapi.service;

import com.nhnacademy.taskapi.request.MilestoneRequest;
import com.nhnacademy.taskapi.response.MilestoneResponse;

import java.util.List;

public interface MilestoneService {
    void createMilestone(MilestoneRequest milestoneRequest);
    List<MilestoneResponse> findProjectMilestone(Long projectNum);
    void deleteMilestone(Long milestoneNum);
}
