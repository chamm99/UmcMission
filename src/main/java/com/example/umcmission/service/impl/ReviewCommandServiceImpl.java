package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.RestaurantHandler;
import com.example.umcmission.apiPayload.exception.handler.UserHandler;
import com.example.umcmission.converter.ReviewConverter;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.domain.User;
import com.example.umcmission.repository.RestaurantRepository;
import com.example.umcmission.repository.ReviewRepository;
import com.example.umcmission.repository.UserRepository;
import com.example.umcmission.service.ReviewCommandService;
import com.example.umcmission.web.dto.ReviewRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    public Review addReview(Long storeId, ReviewRequestDto.JoinDto request) {
        Restaurant restaurant = restaurantRepository.findById(storeId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // 하드 코딩된 멤버
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, restaurant, user);

        return reviewRepository.save(review);
    }
}
