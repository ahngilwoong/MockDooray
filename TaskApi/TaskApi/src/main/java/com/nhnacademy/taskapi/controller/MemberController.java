package com.nhnacademy.taskapi.controller;

import com.nhnacademy.taskapi.request.MemberRequest;
import com.nhnacademy.taskapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/addmember")
    public void addMemberToProject(@RequestBody MemberRequest memberRequest){
        memberService.addProjectMember(memberRequest);
    }

}
