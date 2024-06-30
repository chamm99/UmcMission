package com.example.umcmission.web.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDto {

    @Builder
    public record JoinResultDto (
            Long missionId,
            Long restaurantId,
            LocalDateTime createdAt
    ) {
    }

    @Builder
    public record MissionPreviewListDto (
            List<MissionResponseDto.MissionPreviewDto> missionPreviewDtoList,
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
