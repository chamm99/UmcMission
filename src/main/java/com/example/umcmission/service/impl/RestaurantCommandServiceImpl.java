package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.RegionHandler;
import com.example.umcmission.converter.RestaurantConverter;
import com.example.umcmission.domain.Region;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.repository.RegionRepository;
import com.example.umcmission.repository.RestaurantRepository;
import com.example.umcmission.service.RestaurantCommandService;
import com.example.umcmission.web.dto.RestaurantRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    public Restaurant joinRestaurant(RestaurantRequestDto.JoinRequestDto request, Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);
        newRestaurant.updateRegion(region);

        return restaurantRepository.save(newRestaurant);
    }
}
