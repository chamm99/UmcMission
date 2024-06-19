package com.example.umcmission.service;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.web.dto.MissionRequestDto;

public interface MissionCommandService {
    Mission addMission(Long restaurantId, MissionRequestDto.JoinDto request);

}
