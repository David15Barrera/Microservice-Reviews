package com.service.reviewsService.review.infrastructure.outputadapter.persistence.repository;

import com.service.reviewsService.review.infrastructure.outputadapter.persistence.entity.ReviewDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewDBRepository extends JpaRepository<ReviewDBEntity, UUID> {

    List<ReviewDBEntity> findByHotelId(UUID hotelId);
    List<ReviewDBEntity> findByDishId(UUID dishId);
    List<ReviewDBEntity> findByRoomId(UUID roomId);
    List<ReviewDBEntity> findByRestaurantId(UUID restaurantId);

}
