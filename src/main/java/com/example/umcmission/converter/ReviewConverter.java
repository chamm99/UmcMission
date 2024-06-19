package com.example.umcmission.converter;

import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.domain.User;
import com.example.umcmission.web.dto.ReviewRequestDto;
import com.example.umcmission.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDto.JoinResultDto toJoinResultDTO(Review review) {
        return ReviewResponseDto.JoinResultDto.builder()
                .userId(1L)
                .restaurantId(review.getRestaurant().getId())
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDto.JoinDto request, Restaurant restaurant, User user) {
        return Review.builder()
                .content(request.content())
                .score(request.score())
                .restaurant(restaurant)
                .user(user)
                .build();
    }
}
