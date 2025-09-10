package com.service.reviewsService.review.infrastructure.outputadapter.persistence;

import com.service.reviewsService.common.infrastructure.annotation.PersistenceAdapter;
import com.service.reviewsService.review.application.ports.output.*;
import com.service.reviewsService.review.domain.ReviewDomainEntity;
import com.service.reviewsService.review.infrastructure.outputadapter.persistence.entity.ReviewDBEntity;
import com.service.reviewsService.review.infrastructure.outputadapter.persistence.mapper.ReviewRepositoryMapper;
import com.service.reviewsService.review.infrastructure.outputadapter.persistence.repository.ReviewDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@PersistenceAdapter
@RequiredArgsConstructor
public class ReviewRepositoryOutputAdapter implements StoringReviewOutputPort, FindingAllReviewsByHotelIdOutputPort,
        FindingAllReviewsByRestaurantIdOutputPort, FindingAllReviewsByRoomIdOutputPort, FindingAllReviewsByDishesIdOutputPort {

    private final ReviewDBRepository reviewDBRepository;
    private final ReviewRepositoryMapper reviewRepositoryMapper;

    @Override
    @Transactional
    public void saveReview(ReviewDomainEntity review) {
        ReviewDBEntity reviewDBEntity = reviewRepositoryMapper.toDBEntity(review);
        this.reviewDBRepository.save(reviewDBEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReviewDomainEntity> findAllReviewsByHotelId(UUID hotelId) {
        return reviewDBRepository.findByHotelId(hotelId).stream()
                .map(reviewRepositoryMapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<ReviewDomainEntity> findAllReviewsByRestaurantId(UUID restaurantId) {
        return reviewDBRepository.findByRestaurantId(restaurantId).stream()
                .map(reviewRepositoryMapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<ReviewDomainEntity> findAllReviewsByDishesId(UUID dishesId) {
        return reviewDBRepository.findByDishId(dishesId).stream()
                .map(reviewRepositoryMapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<ReviewDomainEntity> findAllReviewsByRoomId(UUID roomId) {
        return reviewDBRepository.findByRoomId(roomId).stream()
                .map(reviewRepositoryMapper::toDomainEntity)
                .toList();
    }
}
