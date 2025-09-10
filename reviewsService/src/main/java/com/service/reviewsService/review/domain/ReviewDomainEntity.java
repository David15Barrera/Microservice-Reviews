package com.service.reviewsService.review.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ReviewDomainEntity {

    private UUID id;
    private UUID customerId;
    private UUID hotelId;
    private UUID restaurantId;
    private UUID dishId;
    private UUID roomId;
    private int rating;
    private String comment;
    public Instant createdAt;
    public String nameCustomer;

    public ReviewDomainEntity(UUID customerId) {
        this.customerId = customerId;
    }

    public ReviewDomainEntity(UUID id, UUID customerId, UUID hotelId, UUID restaurantId, UUID dishId, UUID roomId, int rating, String comment, Instant createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.hotelId = hotelId;
        this.restaurantId = restaurantId;
        this.dishId = dishId;
        this.roomId = roomId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }
}
