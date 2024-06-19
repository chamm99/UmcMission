package com.example.umcmission.web.controller;

import com.example.umcmission.annotation.ChallengeMission;
import com.example.umcmission.apiPayload.ApiResponse;
import com.example.umcmission.converter.UserConverter;
import com.example.umcmission.converter.UserMissionConverter;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.service.UserCommandService;
import com.example.umcmission.web.dto.UserMissionResponseDto;
import com.example.umcmission.web.dto.UserRequestDto;
import com.example.umcmission.web.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserCommandService userCommandService;

    @PostMapping("")
    public ApiResponse<UserResponseDto.JoinResultDto> join(
            @RequestBody @Valid UserRequestDto.JoinDto request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDto(user));
    }

    @PostMapping("/{missionId}")
    public ApiResponse<UserMissionResponseDto.JoinResultDto> addMissionToUser(
            @ChallengeMission @PathVariable(name = "missionId") Long missionId
    ) {
        UserMission userMission = userCommandService.addMissionToUser(missionId);
        return ApiResponse.onSuccess(UserMissionConverter.toJoinResultDto(userMission));
    }
}
