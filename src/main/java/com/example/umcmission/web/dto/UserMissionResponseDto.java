package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserMissionResponseDto {
    @Builder
    public record JoinResultDto(
            Long userId,
            Long missionId,
            LocalDateTime createdAt
    ) {
    }
}
