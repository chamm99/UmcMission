package com.example.umcmission.web.controller;

import com.example.umcmission.apiPayload.ApiResponse;
import com.example.umcmission.converter.RestaurantConverter;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.service.RestaurantCommandService;
import com.example.umcmission.web.dto.RestaurantRequestDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/{reginId}")
    public ApiResponse<RestaurantResponseDto.JoinResultDto> joinRestaurant(
            @RequestBody @Valid RestaurantRequestDto.JoinRequestDto request,
            @PathVariable Long reginId) {
        Restaurant restaurant = restaurantCommandService.joinRestaurant(request, reginId);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDto(restaurant, reginId));
    }
}
