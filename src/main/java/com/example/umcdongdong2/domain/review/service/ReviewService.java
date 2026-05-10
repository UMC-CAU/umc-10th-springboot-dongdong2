package com.example.umcdongdong2.domain.review.service;

import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateResDTO;
import com.example.umcdongdong2.domain.review.entity.Review;
import com.example.umcdongdong2.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse createReview(
            RestaurantReviewCreateReqDTO.RestaurantReviewCreateRequest dto
        ){

        Long id = 10L; // 임시 유저 아이디

        Review review = Review.builder().id(id).star(dto.star()).content(dto.content()).build();
        review = reviewRepository.save(review);

        return RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse.builder().reviewId(review.getId()).build();
    }

}
