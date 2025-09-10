package com.service.reviewsService.review.application.ports.output;

import com.service.reviewsService.review.domain.CustomerDomainEntity;

import java.util.List;

public interface FindingAllCustomersOutputPort {
    List<CustomerDomainEntity> findAllCustomers();
}
