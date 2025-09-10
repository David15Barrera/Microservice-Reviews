package com.service.reviewsService.review.application.usecase.Create;

import com.service.reviewsService.common.application.annotations.UseCase;
import com.service.reviewsService.review.application.factory.CreatingReviewFactory;
import com.service.reviewsService.review.application.ports.input.CreatingReviewInputPort;
import com.service.reviewsService.review.application.ports.output.StoringReviewOutputPort;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;


@UseCase
@Validated
@RequiredArgsConstructor
public class CreateReviewUseCase implements CreatingReviewInputPort {

    private final StoringReviewOutputPort storingReviewOutputPort;
    private final CreatingReviewFactory creatingReviewFactory;

    @Override
    public void createReview(CreateReviewCaseDto review) {

        ReviewDomainEntity reviewDomainEntity = creatingReviewFactory.createReview(review);

        storingReviewOutputPort.saveReview(reviewDomainEntity);
    }
}
