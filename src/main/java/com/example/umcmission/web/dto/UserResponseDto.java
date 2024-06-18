package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserResponseDto {

    @Builder
    public record JoinResultDto(
            Long userId,
            LocalDateTime createdAt
    ) {
    }
}
