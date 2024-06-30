package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.RestaurantHandler;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.repository.MissionRepository;
import com.example.umcmission.repository.RestaurantRepository;
import com.example.umcmission.repository.ReviewRepository;
import com.example.umcmission.service.RestaurantQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Restaurant> findStore(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        return reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }
}
