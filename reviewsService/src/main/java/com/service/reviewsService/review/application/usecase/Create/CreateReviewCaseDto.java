package com.service.reviewsService.review.application.usecase.Create;


import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class CreateReviewCaseDto {
    UUID customerId;
    UUID refenceId;
    int rating;
    String comment;
    String typeReference;      
}
