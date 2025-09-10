package com.service.reviewsService.review.infrastructure.outputadapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "reviews")
@Table(name = "reviews", schema = "reviews")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class ReviewDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private UUID customerId;

    @Column(nullable = true)
    private UUID hotelId;

    @Column(nullable = true)
    private UUID restaurantId;

    @Column(nullable = true)
    private UUID dishId;

    @Column(nullable = true)
    private UUID roomId;

    @Column(nullable = true)
    private int rating;

    @Column(nullable = true)
    private String comment;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
