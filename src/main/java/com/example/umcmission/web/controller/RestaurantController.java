package com.example.umcmission.web.controller;

import com.example.umcmission.annotation.CheckPage;
import com.example.umcmission.annotation.ExistRestaurant;
import com.example.umcmission.apiPayload.ApiResponse;
import com.example.umcmission.converter.RestaurantConverter;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.service.RestaurantCommandService;
import com.example.umcmission.service.RestaurantQueryService;
import com.example.umcmission.service.UserQueryService;
import com.example.umcmission.web.dto.RestaurantRequestDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;
    private final UserQueryService userQueryService;

    @PostMapping("/{reginId}")
    public ApiResponse<RestaurantResponseDto.JoinResultDto> joinRestaurant(
            @RequestBody @Valid RestaurantRequestDto.JoinRequestDto request,
            @PathVariable Long reginId) {
        Restaurant restaurant = restaurantCommandService.joinRestaurant(request, reginId);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDto(restaurant, reginId));
    }
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "사용자가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/myReviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<RestaurantResponseDto.ReviewPreviewListDto> getMyReviewList(
            @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Review> reviewList = userQueryService.getUserReviewList(1L, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreviewListDto(reviewList));
    }

    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "특정 식당 미션 목록 조회 API", description = "특정 식당 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "식당 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDto.MissionPreviewListDto> getReviewList(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = restaurantQueryService.getMissionList(restaurantId, page);
        return ApiResponse.onSuccess(RestaurantConverter.toMissionPreviewList(missionList));
    }
}

