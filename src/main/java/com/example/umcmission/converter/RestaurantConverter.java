package com.example.umcmission.converter;

import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.web.dto.RestaurantRequestDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDto.JoinResultDto toJoinResultDto(Restaurant restaurant, Long regionId) {
        return RestaurantResponseDto.JoinResultDto.builder()
                .regionId(regionId)
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDto.JoinRequestDto request) {
        return Restaurant.builder()
                .name(request.name())
                .address(request.address())
                .build();
    }

}
