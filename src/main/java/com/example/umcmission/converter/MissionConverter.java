package com.example.umcmission.converter;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.web.dto.MissionRequestDto;
import com.example.umcmission.web.dto.MissionResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDto.JoinResultDto toJoinResultDTO(Mission mission) {
        return MissionResponseDto.JoinResultDto.builder()
                .missionId(mission.getId())
                .restaurantId(mission.getRestaurant().getId())
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
}
