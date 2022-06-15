package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {
}
