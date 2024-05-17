package com.example.umc6th.domain;

import com.example.umc6th.domain.common.BaseEntity;
import com.example.umc6th.domain.mapping.UserMission;
import com.example.umc6th.domain.mapping.UserRestaurantReview;
import com.example.umc6th.domain.mapping.UserFAQ;
import com.example.umc6th.domain.mapping.UserFoodPreference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private LocalDateTime birthDate;
    private String address;
    private String status;
    private LocalDateTime inactiveDate;
    private Long bossId;
    private String nickname;
    private Long point;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFoodPreference> userFoodPreferenceList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFAQ> userFAQList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRestaurantReview> userRestaurantReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}
