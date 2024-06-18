package com.example.umcmission.converter;

import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.Gender;
import com.example.umcmission.web.dto.UserRequestDto;

import java.util.ArrayList;

public class UserConverter {
    public static User toUser(UserRequestDto.JoinDto request) {
        Gender gender = switch (request.gender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return User.builder()
                .address(request.address())
                .name(request.name())
                .gender(request.gender())
                .userFoodPreferenceList(new ArrayList<>())
                .build();
    }
}
