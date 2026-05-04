package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

import java.util.List;

public class RestaurantReviewCreateReqDTO {

    @Builder
    public record RestaurantReviewCreateRequest(
            Float star,
            String content,
            List<String> imageUrls
    ) {}
}
