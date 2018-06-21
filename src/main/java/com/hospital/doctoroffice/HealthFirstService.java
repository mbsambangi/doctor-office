package com.hospital.doctoroffice;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "HealthFirstService",
    url = "http://localhost:8080", fallback = HealthFirstService.HealthFirstServiceFallback.class)
public interface HealthFirstService {

    @RequestMapping(method = RequestMethod.POST, path = "/members")
    @Headers("Accept:application/json;charset=UTF-8")
    HealthFirstMember verifyCoverage(@RequestBody HealthFirstMember member);

    @Component
    class HealthFirstServiceFallback implements HealthFirstService {
        @Override
        public HealthFirstMember verifyCoverage(@RequestBody HealthFirstMember member) {
            member.setCoverage(HealthFirstMember.Coverage.NONE);
            return member;
        }
    }
}


