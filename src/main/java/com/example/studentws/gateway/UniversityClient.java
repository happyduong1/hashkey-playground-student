package com.example.studentws.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.studentws.dto.UniversityDto;

@FeignClient(value = "university-client", url = "${demo.restclient.university-ws}")
public interface UniversityClient {

    @GetMapping(value = "${demo.api.university-ws.get-university-by-id}")
    UniversityDto getUniversityById(@PathVariable long id);
}
