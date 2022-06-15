package com.nhnacademy.gatewayserver.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private Long memberNum;
    private Long projectNum;
    private String memberId;
    private String memberName;
}
