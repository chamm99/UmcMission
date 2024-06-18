package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.FoodPreferenceHandler;
import com.example.umcmission.apiPayload.exception.handler.MissionHandler;
import com.example.umcmission.apiPayload.exception.handler.UserHandler;
import com.example.umcmission.converter.UserConverter;
import com.example.umcmission.converter.UserFoodPreferenceConverter;
import com.example.umcmission.converter.UserMissionConverter;
import com.example.umcmission.domain.FoodPreference;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.mapping.UserFoodPreference;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.repository.FoodPreferenceRepository;
import com.example.umcmission.repository.MissionRepository;
import com.example.umcmission.repository.UserMissionRepository;
import com.example.umcmission.repository.UserRepository;
import com.example.umcmission.service.UserCommandService;
import com.example.umcmission.web.dto.UserRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public User joinUser(UserRequestDto.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodPreference> foodPreferenceList = request.preference().stream()
                .map(preference -> foodPreferenceRepository.findById(preference)
                .orElseThrow(() -> new FoodPreferenceHandler(ErrorStatus.FOOD_PREFERENCE_NOT_FOUND))).toList();

        List<UserFoodPreference> userFoodPreferenceList = UserFoodPreferenceConverter.toUserFoodPreferenceList(foodPreferenceList);
        for (UserFoodPreference userFoodPreference : userFoodPreferenceList) {
            userFoodPreference.updateUser(newUser);
        }
        return userRepository.save(newUser);
    }

    @Override
    public UserMission addMissionToUser(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 하드 코딩 멤버
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toUserMission(mission, user);

        return userMissionRepository.save(userMission);
    }
}
