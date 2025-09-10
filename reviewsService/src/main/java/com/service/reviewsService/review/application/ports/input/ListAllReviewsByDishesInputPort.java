package com.service.reviewsService.review.application.ports.input;

import com.service.reviewsService.review.domain.ReviewDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllReviewsByDishesInputPort {

    List<ReviewDomainEntity> listAllReviewsByDishesId(UUID hotelId);
}
