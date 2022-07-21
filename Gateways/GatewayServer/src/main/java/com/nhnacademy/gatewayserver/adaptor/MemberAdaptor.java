package com.nhnacademy.gatewayserver.adaptor;

import com.nhnacademy.gatewayserver.request.MemberRequest;

public interface MemberAdaptor {

    void registerMemberToProject(MemberRequest memberRequest);
}
