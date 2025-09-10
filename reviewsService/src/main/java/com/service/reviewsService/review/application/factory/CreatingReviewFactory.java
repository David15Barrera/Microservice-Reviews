package com.service.reviewsService.review.application.factory;

import com.service.reviewsService.review.application.usecase.Create.CreateReviewCaseDto;
import com.service.reviewsService.review.domain.ReviewDomainEntity;

public interface CreatingReviewFactory {
    ReviewDomainEntity createReview(CreateReviewCaseDto review);
}
