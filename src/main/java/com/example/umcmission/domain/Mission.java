package com.example.umcmission.domain;

import com.example.umcmission.domain.common.BaseEntity;
import com.example.umcmission.domain.mapping.UserMission;
import com.example.umcmission.domain.mapping.UserRestaurantReview;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int point;
    private LocalDate untilWhen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}
