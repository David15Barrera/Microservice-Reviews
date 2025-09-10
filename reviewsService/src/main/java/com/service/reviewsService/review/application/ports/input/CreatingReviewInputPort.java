package com.service.reviewsService.review.application.ports.input;

import com.service.reviewsService.review.application.usecase.Create.CreateReviewCaseDto;

public interface CreatingReviewInputPort {
    void createReview(CreateReviewCaseDto review);
}
