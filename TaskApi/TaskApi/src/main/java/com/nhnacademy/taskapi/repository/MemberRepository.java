package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Members;
import com.nhnacademy.taskapi.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Members, Long> {

        @Query("select m.project from Members m where m.memberId = ?1")
        List<Projects> findProjectByMemberId(String memberId);

        Members findByMemberId(String memberId);



}
