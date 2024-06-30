package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RestaurantResponseDto {

    @Builder
    public record JoinResultDto (
            Long regionId,
            Long restaurantId,
            LocalDateTime createdAt
    ) {
    }

    @Builder
    public record ReviewPreviewListDto (
            List<ReviewPreviewDto> reviewPreviewDtoList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record ReviewPreviewDto (
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ) {}

    @Builder
    public record MissionPreviewListDto (
            List<MissionPreviewDto> missionPreviewDtoList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MissionPreviewDto (
            Integer point,
            LocalDate untilWhen
    ) {}
}
