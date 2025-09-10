package com.service.reviewsService.review.infrastructure.outputadapter.factory;

import com.service.reviewsService.common.infrastructure.exception.BadRequestException;
import com.service.reviewsService.review.application.factory.CreatingReviewFactory;
import com.service.reviewsService.review.application.factory.ListReviewWithCustomerNameFactory;
import com.service.reviewsService.review.application.ports.output.FindingAllCustomersOutputPort;
import com.service.reviewsService.review.application.usecase.Create.CreateReviewCaseDto;
import com.service.reviewsService.review.domain.CustomerDomainEntity;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FactoryOutputAdapter implements CreatingReviewFactory, ListReviewWithCustomerNameFactory {

    private final FindingAllCustomersOutputPort findingAllCustomersOutputPort;

    private static final Map<String, BiConsumer<ReviewDomainEntity, UUID>> referenceHandlers = Map.of(
            "hotel", ReviewDomainEntity::setHotelId,
            "room", ReviewDomainEntity::setRoomId,
            "restaurant", ReviewDomainEntity::setRestaurantId,
            "dishes", ReviewDomainEntity::setDishId
    );


    @Override
    public ReviewDomainEntity createReview(CreateReviewCaseDto review) {
        ReviewDomainEntity entity = new ReviewDomainEntity(review.getCustomerId());

        referenceHandlers
                .getOrDefault(review.getTypeReference().toLowerCase(),
                        (e, id) -> { throw new BadRequestException("Referencia no valida"); })
                .accept(entity, review.getRefenceId());

        entity.setRating(review.getRating());
        entity.setComment(review.getComment());
        return entity;
    }

    @Override
    public List<ReviewDomainEntity> listAllReviewsByRestaurantId(List<ReviewDomainEntity> reviews) {
        if (reviews.isEmpty()) {
            return reviews;
        }

        List<CustomerDomainEntity> customers = findingAllCustomersOutputPort.findAllCustomers();
        Map<UUID, String> customerMap = customers.stream()
                .collect(Collectors.toMap(CustomerDomainEntity::getId, CustomerDomainEntity::getFullName));
        reviews.forEach(review ->
                review.setNameCustomer(customerMap.get(review.getCustomerId()))
        );

        return reviews;
    }
}

