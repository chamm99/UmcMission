package com.example.umcmission.web.controller;

import com.example.umcmission.apiPayload.ApiResponse;
import com.example.umcmission.converter.MissionConverter;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.service.MissionCommandService;
import com.example.umcmission.web.dto.MissionRequestDto;
import com.example.umcmission.web.dto.MissionResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{restaurantId}")
    public ApiResponse<MissionResponseDto.JoinResultDto> addMission(
            @RequestBody @Valid MissionRequestDto.JoinDto request,
            @PathVariable Long restaurantId
            ) {
        Mission mission = missionCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
