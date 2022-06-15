package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tags,Long> {
}
