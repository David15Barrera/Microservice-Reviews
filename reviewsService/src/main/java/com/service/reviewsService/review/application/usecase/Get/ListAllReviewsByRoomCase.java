package com.service.reviewsService.review.application.usecase.Get;

import com.service.reviewsService.common.application.annotations.UseCase;
import com.service.reviewsService.review.application.factory.ListReviewWithCustomerNameFactory;
import com.service.reviewsService.review.application.ports.input.ListAllReviewsByRoomInputPort;
import com.service.reviewsService.review.application.ports.output.FindingAllReviewsByRoomIdOutputPort;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ListAllReviewsByRoomCase implements ListAllReviewsByRoomInputPort {

    private final ListReviewWithCustomerNameFactory factory;
    private final FindingAllReviewsByRoomIdOutputPort findingAllReviewsByRoomIdOutputPort;

    @Override
    public List<ReviewDomainEntity> listAllReviewsByRoomId(UUID roomId) {
        // obtener los reviews
        List<ReviewDomainEntity> reviews = findingAllReviewsByRoomIdOutputPort.findAllReviewsByRoomId(roomId);

        return factory.listAllReviewsByRestaurantId(reviews);
    }
}
