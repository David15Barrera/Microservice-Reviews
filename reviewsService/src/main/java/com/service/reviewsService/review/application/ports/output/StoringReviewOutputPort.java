package com.service.reviewsService.review.application.ports.output;

import com.service.reviewsService.review.domain.ReviewDomainEntity;

public interface StoringReviewOutputPort {
    void saveReview(ReviewDomainEntity review);
}
