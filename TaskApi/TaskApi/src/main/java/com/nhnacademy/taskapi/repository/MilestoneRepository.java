package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Milestones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestones,Long> {

}
