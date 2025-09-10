package com.service.reviewsService.review.application.ports.output;

import com.service.reviewsService.review.domain.ReviewDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllReviewsByRoomIdOutputPort {

    List<ReviewDomainEntity> findAllReviewsByRoomId(UUID roomId);
}
