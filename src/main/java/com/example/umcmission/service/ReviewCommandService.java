package com.example.umcmission.service;

import com.example.umcmission.domain.Review;
import com.example.umcmission.web.dto.ReviewRequestDto;

public interface ReviewCommandService {
    Review addReview(Long restaurantId, ReviewRequestDto.JoinDto request);

}
