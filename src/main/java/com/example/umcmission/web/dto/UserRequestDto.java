package com.example.umcmission.web.dto;

import java.util.List;

public class UserRequestDto{
    public record JoinDto(
            String name,
            Integer gender,
            Integer birthYear,
            Integer birthMonth,
            Integer birthDay,
            String address,
            List<Long> preference
    ) {
    }
}
