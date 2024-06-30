package com.example.umcmission.web.dto;

import com.example.umcmission.converter.RestaurantConverter;
import com.example.umcmission.domain.Review;
import lombok.Builder;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewResponseDto {

    @Builder
    public record JoinResultDto (
            Long userId,
            Long restaurantId,
            Long reviewId,
            LocalDateTime createdAt
    ) {}
//
//    public static RestaurantResponseDto.ReviewPreviewDto reviewPreViewDTO(Review review){
//        return RestaurantResponseDto.ReviewPreviewDto.builder()
//                .ownerNickname(review.getUser().getNickname())
//                .score(review.getScore())
//                .createdAt(review.getCreatedAt().toLocalDate())
//                .body(review.getBody())
//                .build();
//    }
//    public static RestaurantResponseDto.ReviewPreviewListDto reviewPreViewListDTO(Page<Review> reviewList){
//
//        List<RestaurantResponseDto.ReviewPreviewDto> reviewPreViewDtoList = reviewList.stream()
//                .map(RestaurantConverter::reviewPreviewDto).collect(Collectors.toList());
//
//        return RestaurantResponseDto.ReviewPreviewListDto.builder()
//                .isLast(reviewList.isLast())
//                .isFirst(reviewList.isFirst())
//                .totalPage(reviewList.getTotalPages())
//                .totalElements(reviewList.getTotalElements())
//                .listSize(reviewPreViewDtoList.size())
//                .reviewPreviewDtoList(reviewPreViewDtoList)
//                .build();
//    }
}
