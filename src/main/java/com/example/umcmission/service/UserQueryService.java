package com.example.umcmission.service;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Review;
import org.springframework.data.domain.Page;

public interface UserQueryService {

    Page<Review> getUserReviewList(Long userId, Integer page);
    Page<Mission> getUserMissions(Long userId, Integer page);
}
