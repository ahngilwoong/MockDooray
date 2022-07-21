package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.response.ProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Projects,Long> {
    Optional<ProjectResponse> findByProjectNum(Long projectNum);


}
