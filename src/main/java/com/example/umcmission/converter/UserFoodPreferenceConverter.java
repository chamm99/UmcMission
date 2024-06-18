package com.example.umcmission.converter;

import com.example.umcmission.domain.FoodPreference;
import com.example.umcmission.domain.mapping.UserFoodPreference;

import java.util.List;

public class UserFoodPreferenceConverter {
    public static List<UserFoodPreference> toUserFoodPreferenceList(List<FoodPreference> foodPreferenceList) {
        return foodPreferenceList.stream()
                .map(foodPreference -> UserFoodPreference.builder()
                                .foodPreference(foodPreference)
                                .build()
                ).toList();
    }
}
