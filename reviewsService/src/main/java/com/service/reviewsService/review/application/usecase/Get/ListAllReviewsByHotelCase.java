package com.service.reviewsService.review.application.usecase.Get;

import com.service.reviewsService.common.application.annotations.UseCase;
import com.service.reviewsService.review.application.factory.ListReviewWithCustomerNameFactory;
import com.service.reviewsService.review.application.ports.input.ListAllReviewsByHotelInputPort;
import com.service.reviewsService.review.application.ports.output.FindingAllReviewsByHotelIdOutputPort;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@UseCase
@RequiredArgsConstructor
public class ListAllReviewsByHotelCase implements ListAllReviewsByHotelInputPort {

    private final FindingAllReviewsByHotelIdOutputPort findingAllReviewsByHotelIdOutputPort;
    private final ListReviewWithCustomerNameFactory factory;

    @Override
    public List<ReviewDomainEntity> listAllReviewsByHotelId(UUID hotelId) {

        // obtener los reviews
        List<ReviewDomainEntity> reviews = findingAllReviewsByHotelIdOutputPort.findAllReviewsByHotelId(hotelId);

       return factory.listAllReviewsByRestaurantId(reviews);
    }
}
