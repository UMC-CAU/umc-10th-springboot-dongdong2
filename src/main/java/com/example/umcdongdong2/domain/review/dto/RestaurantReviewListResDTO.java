package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

import java.util.List;

public class RestaurantReviewListResDTO {

    @Builder
    public record Review(
            Long reviewId,
            Float star,
            String content
    ) {}

    @Builder
    public record RestaurantReviewListResponse(
            List<Review> reviews,
            Integer page,
            Integer size,
            Long totalElements,
            Integer totalPages,
            Boolean hasNext
    ) {}
}
