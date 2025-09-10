package com.service.reviewsService.review.application.usecase.Get;

import com.service.reviewsService.common.application.annotations.UseCase;
import com.service.reviewsService.review.application.factory.ListReviewWithCustomerNameFactory;
import com.service.reviewsService.review.application.ports.input.ListAllReviewsByRestaurantInputPort;
import com.service.reviewsService.review.application.ports.output.FindingAllReviewsByRestaurantIdOutputPort;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@UseCase
@RequiredArgsConstructor
public class ListAllReviewsByRestaurantCase implements ListAllReviewsByRestaurantInputPort {

    private final FindingAllReviewsByRestaurantIdOutputPort  findingAllReviewsByRestaurantIdOutputPort;
    private final ListReviewWithCustomerNameFactory factory;

    @Override
    public List<ReviewDomainEntity> listAllReviewsByRestaurantId(UUID restaurantId) {

        List<ReviewDomainEntity> reviews = findingAllReviewsByRestaurantIdOutputPort.findAllReviewsByRestaurantId(restaurantId);

        return factory.listAllReviewsByRestaurantId(reviews);
    }
}
