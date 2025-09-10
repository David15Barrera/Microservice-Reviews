package com.service.reviewsService.review.infrastructure.outputadapter.feing.rest;

import com.service.reviewsService.review.infrastructure.outputadapter.feing.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "auth-identity", url = "${client.services.auth-identity}/api/auth-identity")
public interface AuthIdentityRestClient {

    @GetMapping("/v1/customers")
    List<CustomerResponseDto> findAllCustomers();
}
