package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResponseDto {

    @Builder
    public record JoinResultDto (
            Long userId,
            Long restaurantId,
            Long reviewId,
            LocalDateTime createdAt
    ) {
    }
}
