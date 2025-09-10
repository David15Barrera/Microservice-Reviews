package com.service.reviewsService.review.application.factory;

import com.service.reviewsService.review.domain.ReviewDomainEntity;

import java.util.List;

public interface ListReviewWithCustomerNameFactory {
    List<ReviewDomainEntity> listAllReviewsByRestaurantId(List<ReviewDomainEntity> reviews );
}
