package com.service.reviewsService.review.infrastructure.inputadapter.rest;


import com.service.reviewsService.common.infrastructure.annotation.WebAdapter;
import com.service.reviewsService.review.application.ports.input.*;
import com.service.reviewsService.review.application.usecase.Create.CreateReviewCaseDto;
import com.service.reviewsService.review.infrastructure.inputadapter.dto.CreatReviewRequestDto;
import com.service.reviewsService.review.infrastructure.inputadapter.dto.ReviewResponseDto;
import com.service.reviewsService.review.infrastructure.inputadapter.mapper.MapperRestInputAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/reviews")
@WebAdapter
@RequiredArgsConstructor
public class ReviewControllerAdapter {

    private final CreatingReviewInputPort creatingReviewInputPort;
    private final ListAllReviewsByHotelInputPort listAllReviewsByHotelInputPort;
    private final ListAllReviewsByRoomInputPort listAllReviewsByRoomInputPort;
    private final ListAllReviewsByRestaurantInputPort listAllReviewsByRestaurantInputPort;
    private final ListAllReviewsByDishesInputPort  listAllReviewsByDishesInputPort;
    private final MapperRestInputAdapter mapperRestInputAdapter;

    @PostMapping()
    @Transactional
    public ResponseEntity<Void> createReview(@RequestBody @Valid CreatReviewRequestDto creatReviewRequestDto){

        CreateReviewCaseDto createReviewCaseDto = creatReviewRequestDto.toCase();

        creatingReviewInputPort.createReview(createReviewCaseDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsFindByHoteltId(@PathVariable UUID hotelId){
        List<ReviewResponseDto> dtoList = listAllReviewsByHotelInputPort.listAllReviewsByHotelId(hotelId)
                .stream()
                .map(mapperRestInputAdapter::toReviewHotelResponseDto)
                .toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsFindByRestaurantId(@PathVariable UUID restaurantId){
        List<ReviewResponseDto> dtoList = listAllReviewsByRestaurantInputPort.listAllReviewsByRestaurantId(restaurantId)
                .stream()
                .map(mapperRestInputAdapter::toReviewHotelResponseDto)
                .toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsFindByRoomId(@PathVariable UUID roomId){
        List<ReviewResponseDto> dtoList = listAllReviewsByRoomInputPort.listAllReviewsByRoomId(roomId)
                .stream()
                .map(mapperRestInputAdapter::toReviewHotelResponseDto)
                .toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/dishes/{dishesId}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsFindByDishesId(@PathVariable UUID dishesId){
        List<ReviewResponseDto> dtoList = listAllReviewsByDishesInputPort.listAllReviewsByDishesId(dishesId)
                .stream()
                .map(mapperRestInputAdapter::toReviewHotelResponseDto)
                .toList();

        return ResponseEntity.ok().body(dtoList);
    }
}
