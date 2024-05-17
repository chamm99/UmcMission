package com.example.umc6th.domain;

import com.example.umc6th.domain.common.BaseEntity;
import com.example.umc6th.domain.mapping.UserFoodPreference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodPreference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "foodPreference", cascade = CascadeType.ALL)
    private List<UserFoodPreference> userFoodPreferenceList = new ArrayList<>();
}
