package com.service.reviewsService.review.infrastructure.inputadapter.dto;

import com.service.reviewsService.review.application.usecase.Create.CreateReviewCaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.util.UUID;

@Value
public class CreatReviewRequestDto{
    @NotNull
    UUID customerId;

    @NotNull
    UUID refenceId;

    @Positive
    int rating;

    @NotBlank
    String comment;

    @NotBlank
    String typeReference;

    public CreateReviewCaseDto toCase(){
        return new CreateReviewCaseDto(customerId,  refenceId, rating, comment, typeReference);
    }
}
