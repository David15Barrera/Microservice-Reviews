package com.service.reviewsService.review.application.usecase.Get;

import com.service.reviewsService.common.application.annotations.UseCase;
import com.service.reviewsService.review.application.factory.ListReviewWithCustomerNameFactory;
import com.service.reviewsService.review.application.ports.input.ListAllReviewsByDishesInputPort;
import com.service.reviewsService.review.application.ports.output.FindingAllReviewsByDishesIdOutputPort;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ListAllReviewsByDishesCase implements ListAllReviewsByDishesInputPort {

    private final ListReviewWithCustomerNameFactory factory;
    private final FindingAllReviewsByDishesIdOutputPort findingAllReviewsByDishesIdOutputPort;


    @Override
    public List<ReviewDomainEntity> listAllReviewsByDishesId(UUID hotelId) {
        // obtener los reviews
        List<ReviewDomainEntity> reviews = findingAllReviewsByDishesIdOutputPort.findAllReviewsByDishesId(hotelId);

        return factory.listAllReviewsByRestaurantId(reviews);
    }
}
