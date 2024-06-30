package com.example.umcmission.converter;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.web.dto.MissionRequestDto;
import com.example.umcmission.web.dto.MissionResponseDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDto.JoinResultDto toJoinResultDTO(Mission mission) {
        return MissionResponseDto.JoinResultDto.builder()
                .missionId(mission.getId())
                .restaurantId(mission.getRestaurant().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MissionResponseDto.JoinResultDto toJoinResultDTO(UserMission mission) {
        return MissionResponseDto.JoinResultDto.builder()
                .missionId(mission.getId())
                .restaurantId(mission.getMission().getRestaurant().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDto.JoinDto request, Restaurant restaurant) {
        return Mission.builder()
                .point(request.reward())
                .untilWhen(request.deadline())
                .restaurant(restaurant)
                .build();
    }

    public static MissionResponseDto.MissionPreviewListDto toMissionPreviewList(Page<Mission> missionList) {
        List<MissionResponseDto.MissionPreviewDto> missionPreviewDtoList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDto).collect(Collectors.toList());
        return MissionResponseDto.MissionPreviewListDto.builder()
                .missionPreviewDtoList(missionPreviewDtoList)
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDtoList.size())
                .build();
    }
    public static MissionResponseDto.MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return MissionResponseDto.MissionPreviewDto.builder()
                .point(mission.getPoint())
                .untilWhen(LocalDate.now())
                .build();
    }
}
