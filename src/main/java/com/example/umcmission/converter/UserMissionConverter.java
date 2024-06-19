package com.example.umcmission.converter;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.web.dto.UserMissionResponseDto;

import java.time.LocalDateTime;

import static com.example.umcmission.domain.enums.MissionStatus.CHALLENGING;

public class UserMissionConverter {
    public static UserMission toUserMission(Mission mission, User user) {
        return UserMission.builder()
                .mission(mission)
                .user(user)
                .status(CHALLENGING)
                .build();
    }

    public static UserMissionResponseDto.JoinResultDto toJoinResultDto(UserMission userMission) {
        return UserMissionResponseDto.JoinResultDto.builder()
                .userId(1L)
                .missionId(userMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
