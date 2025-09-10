package com.service.reviewsService.review.infrastructure.inputadapter.mapper;

import com.service.reviewsService.review.domain.ReviewDomainEntity;
import com.service.reviewsService.review.infrastructure.inputadapter.dto.ReviewResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MapperRestInputAdapter {

    public ReviewResponseDto toReviewHotelResponseDto(ReviewDomainEntity entity) {
        return ReviewResponseDto.builder()
                .id(entity.getId())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .createdAt(entity.getCreatedAt())
                .createdAt(entity.getCreatedAt())
                .customerId(entity.getCustomerId())
                .customerName(entity.getNameCustomer())
                .build();
    }
}
