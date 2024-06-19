package com.example.umcmission.web.dto;

public class RestaurantRequestDto {
    public record JoinRequestDto (
            String name,
            String address
    ) {
    }
}
