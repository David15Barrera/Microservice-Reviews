package com.service.reviewsService.review.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CustomerDomainEntity {

    private UUID id;
    private String fullName;

    public CustomerDomainEntity(UUID id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
