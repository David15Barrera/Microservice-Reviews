package com.service.reviewsService.review.infrastructure.outputadapter.feing.dto;


import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record CustomerResponseDto(
        UUID id,
        String email,
        String fullName,
        String cui,
        String phone,
        String address,
        int loyaltyPoints
) {
}
