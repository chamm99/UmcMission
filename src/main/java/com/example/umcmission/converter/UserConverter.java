package com.example.umcmission.converter;

import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.Gender;
import com.example.umcmission.web.dto.UserRequestDto;
import com.example.umcmission.web.dto.UserResponseDto;

import java.time.LocalDateTime;
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

    public static UserResponseDto.JoinResultDto toJoinResultDto(User user) {
        return UserResponseDto.JoinResultDto.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
