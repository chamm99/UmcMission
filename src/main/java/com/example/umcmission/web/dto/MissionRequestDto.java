package com.example.umcmission.web.dto;

import java.time.LocalDate;

public class MissionRequestDto {

    public record JoinDto (
            Integer reward,
            LocalDate deadline,
            String missionSpec
    ) {
    }
}
