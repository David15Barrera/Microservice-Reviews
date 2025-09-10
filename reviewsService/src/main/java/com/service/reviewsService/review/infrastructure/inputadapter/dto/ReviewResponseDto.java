package com.service.reviewsService.review.infrastructure.inputadapter.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
public record ReviewResponseDto(
        UUID id,
        UUID customerId,
        String customerName,
        int rating,
        String comment,
        Instant createdAt
) {
}
