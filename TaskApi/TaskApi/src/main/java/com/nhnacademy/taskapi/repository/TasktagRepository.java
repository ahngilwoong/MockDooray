package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Tasktags;
import com.nhnacademy.taskapi.entity.TasktagsPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasktagRepository extends JpaRepository<Tasktags, TasktagsPk> {
}
