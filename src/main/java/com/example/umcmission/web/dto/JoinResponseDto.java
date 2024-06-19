package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class JoinResponseDto {

    @Builder
    public record JoinResultDto (
            Long regionId,
            Long restaurantId,
            LocalDateTime createdAt
    ) {
    }
}
