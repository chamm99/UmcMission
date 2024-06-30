package com.example.umcmission.converter;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.web.dto.RestaurantRequestDto;
import com.example.umcmission.web.dto.RestaurantResponseDto;
import com.example.umcmission.web.dto.ReviewRequestDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Review toReview(ReviewRequestDto.JoinDto request) {
        return Review.builder()
                .score(request.score())
                .content(request.content())
                .build();
    }

    public static RestaurantResponseDto.ReviewPreviewDto reviewPreviewDto(Review review) {
        return RestaurantResponseDto.ReviewPreviewDto.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(LocalDate.now())
                .body(review.getBody())
                .build();
    }

    public static RestaurantResponseDto.ReviewPreviewListDto reviewPreviewListDto(Page<Review> reviewList) {
        List<RestaurantResponseDto.ReviewPreviewDto> reviewPreviewDtoList = reviewList.stream()
                .map(RestaurantConverter::reviewPreviewDto).collect(Collectors.toList());

        return RestaurantResponseDto.ReviewPreviewListDto.builder()
                .reviewPreviewDtoList(reviewPreviewDtoList)
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDtoList.size())
                .build();
    }

    public static RestaurantResponseDto.MissionPreviewListDto toMissionPreviewList(Page<Mission> missionList) {
        List<RestaurantResponseDto.MissionPreviewDto> missionPreviewDtoList = missionList.stream()
                .map(RestaurantConverter::toMissionPreviewDto).collect(Collectors.toList());
        return RestaurantResponseDto.MissionPreviewListDto.builder()
                .missionPreviewDtoList(missionPreviewDtoList)
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDtoList.size())
                .build();
    }
    public static RestaurantResponseDto.MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return RestaurantResponseDto.MissionPreviewDto.builder()
                .point(mission.getPoint())
                .untilWhen(mission.getUntilWhen())
                .build();
    }
}
