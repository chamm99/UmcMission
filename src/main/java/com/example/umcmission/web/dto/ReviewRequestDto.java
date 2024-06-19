package com.example.umcmission.web.dto;

public class ReviewRequestDto {

    public record JoinDto(
            String content,
            String score
    ) {
    }
}
