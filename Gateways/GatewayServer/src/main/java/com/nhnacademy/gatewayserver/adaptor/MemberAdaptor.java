package com.nhnacademy.gatewayserver.adaptor;

import com.nhnacademy.gatewayserver.request.MemberRequest;

public interface MemberAdaptor {
    Long findMemberNum(String userId);
    void registerMemberToProject(MemberRequest memberRequest);
}
