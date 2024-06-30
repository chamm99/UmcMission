package com.example.umcmission.web.controller;

import com.example.umcmission.annotation.CheckPage;
import com.example.umcmission.apiPayload.ApiResponse;
import com.example.umcmission.converter.MissionConverter;
import com.example.umcmission.converter.RestaurantConverter;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.service.MissionCommandService;
import com.example.umcmission.service.UserQueryService;
import com.example.umcmission.web.dto.MissionRequestDto;
import com.example.umcmission.web.dto.MissionResponseDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;
import com.example.umcmission.web.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/{restaurantId}")
    public ApiResponse<MissionResponseDto.JoinResultDto> addMission(
            @RequestBody @Valid MissionRequestDto.JoinDto request,
            @PathVariable Long restaurantId
            ) {
        Mission mission = missionCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "사용자가 진행 중인 미션 목록을 조회합니다. 페이지와 관련된 쿼리 스트링을 사용하여 페이지네이션을 지원합니다.")
    @GetMapping("/myMissions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공적으로 미션 목록을 조회함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원을 찾을 수 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getUserMissions(
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = userQueryService.getUserMissions(1L, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreviewList(missionList));
    }

    @Operation(summary = "진행 중인 미션 진행 완료로 변경 API", description = "사용자의 진행 중인 미션을 진행 완료로 변경합니다.")
    @PutMapping("/{missionId}/missionComplete")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 진행 완료로 변경 성공", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "미션을 찾을 수 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "missionId", description = "변경할 미션의 아이디", in = ParameterIn.PATH),
    })
    public ApiResponse<MissionResponseDto.JoinResultDto> MissionComplete(
            @PathVariable Long missionId) {

        UserMission mission = missionCommandService.missionComplete(1L, missionId);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
