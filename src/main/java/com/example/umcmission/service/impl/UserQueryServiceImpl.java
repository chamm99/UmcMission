package com.example.umcmission.service.impl;

import com.example.umcmission.apiPayload.code.status.ErrorStatus;
import com.example.umcmission.apiPayload.exception.handler.UserHandler;
import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Review;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.MissionStatus;
import com.example.umcmission.repository.MissionRepository;
import com.example.umcmission.repository.ReviewRepository;
import com.example.umcmission.repository.UserMissionRepository;
import com.example.umcmission.repository.UserRepository;
import com.example.umcmission.service.UserQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;


    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getUserMissions(Long userId, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return userMissionRepository.findAllByUserAndInChallenging(
                user, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}
