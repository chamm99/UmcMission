package com.example.umc6th.domain;

import com.example.umc6th.domain.common.BaseEntity;
import com.example.umc6th.domain.mapping.UserRestaurantReview;
import com.example.umc6th.domain.photo.ReviewPhoto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String score;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    List<UserRestaurantReview> userRestaurantReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    List<ReviewPhoto> reviewPhotoList = new ArrayList<>();
}
