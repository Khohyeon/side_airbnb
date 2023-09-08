package com.example.airbnb.module.lodging.dto;

public record LodgingSaveRequest(
        Integer userId,
        Integer addressId,
        String title,
        String content

) {
}
