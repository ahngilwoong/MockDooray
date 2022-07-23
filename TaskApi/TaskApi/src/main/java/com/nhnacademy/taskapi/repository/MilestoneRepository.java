package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Milestones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MilestoneRepository extends JpaRepository<Milestones,Long> {
        List<Milestones> findMilestonesByProjectProjectNum(Long projectNum);
}
