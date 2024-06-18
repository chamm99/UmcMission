package com.example.umcmission.service;

import com.example.umcmission.domain.User;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.web.dto.UserRequestDto;

public interface UserCommandService {

    User joinUser(UserRequestDto.JoinDto request);

    UserMission addMissionToUser(Long missionId);
}
