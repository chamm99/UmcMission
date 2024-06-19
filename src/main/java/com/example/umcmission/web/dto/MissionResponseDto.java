package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MissionResponseDto {

    @Builder
    public record JoinResultDto (
            Long missionId,
            Long restaurantId,
            LocalDateTime createdAt
    ) {
    }
}
