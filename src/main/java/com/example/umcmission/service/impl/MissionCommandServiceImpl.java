package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.exception.handler.RestaurantHandler;
import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.converter.MissionConverter;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.repository.MissionRepository;
import com.example.umcmission.repository.RestaurantRepository;
import com.example.umcmission.service.MissionCommandService;
import com.example.umcmission.web.dto.MissionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(Long restaurantId, MissionRequestDto.JoinDto request) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, restaurant);

        return missionRepository.save(newMission);
    }
}
