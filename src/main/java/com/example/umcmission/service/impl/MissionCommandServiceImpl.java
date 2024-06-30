package com.example.umcmission.service.impl;


import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.MissionHandler;
import com.example.umcmission.apiPayload.exception.handler.RestaurantHandler;
import com.example.umcmission.converter.MissionConverter;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.enums.MissionStatus;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.repository.*;
import com.example.umcmission.service.MissionCommandService;

import com.example.umcmission.web.dto.MissionRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Mission addMission(Long restaurantId, MissionRequestDto.JoinDto request) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, restaurant);

        return missionRepository.save(newMission);
    }

    @Override
    public UserMission missionComplete(Long userId, Long missionId) {
        UserMission mission = userMissionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        mission.setStatus(MissionStatus.COMPLETE);
        userMissionRepository.save(mission);

        return mission;
    }
}
