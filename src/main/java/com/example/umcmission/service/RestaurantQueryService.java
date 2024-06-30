package com.example.umcmission.service;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findStore(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);

    Page<Mission> getMissionList(Long restaurantId, Integer page);
}
