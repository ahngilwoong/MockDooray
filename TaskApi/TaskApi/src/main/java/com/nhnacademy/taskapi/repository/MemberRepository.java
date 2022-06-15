package com.nhnacademy.taskapi.repository;

import com.nhnacademy.taskapi.entity.Members;
import com.nhnacademy.taskapi.entity.MembersPk;
import com.nhnacademy.taskapi.entity.Projects;
import com.nhnacademy.taskapi.response.MemberResponse;
import com.nhnacademy.taskapi.response.ProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Members, MembersPk> {

        @Query("select m.memberPk.projectNum as mP from Members m where m.memberPk.memberNum = ?1")
        List<Projects> findProjectByMemberNum(Long memberNum);

        List<MemberResponse>  findAllByMemberPk_MemberNum(Long memberNum);
        Members findByMemberId(String memberId);


        @Query("select DISTINCT  m.memberPk.memberNum as mP from Members m where m.memberId = ?1")
        Long findMemberNumByMemberId(String memberId);

}
