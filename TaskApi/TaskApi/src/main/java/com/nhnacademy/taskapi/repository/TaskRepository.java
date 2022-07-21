package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Tasks;
import com.nhnacademy.taskapi.response.TaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks,Long> {
    List<Tasks> findByProject_ProjectNum(Long projectNum);
}
