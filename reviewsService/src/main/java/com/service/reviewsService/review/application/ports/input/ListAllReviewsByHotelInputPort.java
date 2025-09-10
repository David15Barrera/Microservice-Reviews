package com.service.reviewsService.review.application.ports.input;

import com.service.reviewsService.review.domain.ReviewDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllReviewsByHotelInputPort {

    List<ReviewDomainEntity> listAllReviewsByHotelId(UUID hotelId);
}
