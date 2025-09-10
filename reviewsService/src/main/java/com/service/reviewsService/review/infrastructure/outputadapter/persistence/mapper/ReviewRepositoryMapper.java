package com.service.reviewsService.review.infrastructure.outputadapter.persistence.mapper;

import com.service.reviewsService.review.domain.ReviewDomainEntity;
import com.service.reviewsService.review.infrastructure.outputadapter.persistence.entity.ReviewDBEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepositoryMapper {

    public ReviewDBEntity toDBEntity(ReviewDomainEntity review) {
        return ReviewDBEntity.builder()
                .customerId(review.getCustomerId())
                .hotelId(review.getHotelId())
                .restaurantId(review.getRestaurantId())
                .dishId(review.getDishId())
                .roomId(review.getRoomId())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();
    }

    public ReviewDomainEntity toDomainEntity(ReviewDBEntity dbEntity) {
        return new ReviewDomainEntity(dbEntity.getId(),
                dbEntity.getCustomerId(),
                dbEntity.getHotelId(),
                dbEntity.getRestaurantId(),
                dbEntity.getDishId(),
                dbEntity.getRoomId(),
                dbEntity.getRating(),
                dbEntity.getComment(),
                dbEntity.getCreatedAt());

    }
}
