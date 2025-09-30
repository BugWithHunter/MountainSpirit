package com.bughunters.mountainspirit.crewmember.command.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="member-client",url="localhost:8000/member-client")
public interface MemberServiceClient {
    @GetMapping("/member/crew-regist")
    String updateMemberCrewInfo(long crewId, long cumId);
}
