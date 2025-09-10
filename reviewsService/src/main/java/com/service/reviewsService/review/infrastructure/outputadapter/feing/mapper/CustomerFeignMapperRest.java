package com.service.reviewsService.review.infrastructure.outputadapter.feing.mapper;

import com.service.reviewsService.review.domain.CustomerDomainEntity;
import com.service.reviewsService.review.infrastructure.outputadapter.feing.dto.CustomerResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignMapperRest {

    public CustomerDomainEntity toDomainEntity(CustomerResponseDto  customerResponseDto) {
        return new CustomerDomainEntity(customerResponseDto.id(), customerResponseDto.fullName());
    }
}
