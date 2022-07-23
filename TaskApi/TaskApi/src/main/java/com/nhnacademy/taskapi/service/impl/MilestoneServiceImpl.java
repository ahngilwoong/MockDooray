package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.entity.Milestones;
import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.request.MilestoneRequest;
import com.nhnacademy.taskapi.response.MilestoneResponse;
import com.nhnacademy.taskapi.response.TaskResponse;
import com.nhnacademy.taskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public void createMilestone(MilestoneRequest milestoneRequest) {
        Optional<Projects> projects = projectRepository.findById(milestoneRequest.getProjectNum());
        milestoneRepository.save(Milestones.builder()
                .project(projects.get())
                .milestoneName(milestoneRequest.getMilestoneName())
                .startDate(milestoneRequest.getStartDate())
                .endDate(milestoneRequest.getEndDate())
                .build());
    }

    @Override
    public List<MilestoneResponse> findProjectMilestone(Long projectNum) {
        List<Milestones> milestones = milestoneRepository.findMilestonesByProjectProjectNum(projectNum);
        return milestones.stream().map(milestone -> new MilestoneResponse(milestone)).collect(Collectors.toList());
    }

    @Override
    public void deleteMilestone(Long milestoneNum) {
        milestoneRepository.deleteById(milestoneNum);
    }
}
