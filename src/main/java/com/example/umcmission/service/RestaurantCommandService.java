package com.example.umcmission.service;

import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.web.dto.RestaurantRequestDto;

public interface RestaurantCommandService {
    Restaurant joinRestaurant(RestaurantRequestDto.JoinRequestDto request, Long regionId);
}
