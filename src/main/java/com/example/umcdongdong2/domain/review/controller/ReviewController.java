package com.example.umcdongdong2.domain.review.controller;

import com.example.umcdongdong2.domain.review.dto.RestaurantInfoReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantInfoResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewPhotoListReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewPhotoListResDTO;
import com.example.umcdongdong2.domain.review.exception.code.ReviewSuccessCode;
import com.example.umcdongdong2.global.apiPayload.ApiResponse;
import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

//    private final ReviewService reviewService;

    @GetMapping("/restaurants/{restaurantId}/")
    public ApiResponse<RestaurantInfoResDTO.RestaurantInfoResponse> getRestaurantInfo(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @ModelAttribute RestaurantInfoReqDTO.RestaurantInfoRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.getRestaurantInfo(authorization, restaurantId, dto));
    }

    @GetMapping("/restaurants/{restaurantId}/reviews/lists-photos")
    public ApiResponse<RestaurantReviewPhotoListResDTO.RestaurantReviewPhotoListResponse> getRestaurantReviewPhotos(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @ModelAttribute RestaurantReviewPhotoListReqDTO.RestaurantReviewPhotoListRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.getRestaurantReviewPhotos(authorization, restaurantId, dto));
    }

    @GetMapping("/restaurants/{restaurantId}/reviews/")
    public ApiResponse<RestaurantReviewListResDTO.RestaurantReviewListResponse> getRestaurantReviews(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @ModelAttribute RestaurantReviewListReqDTO.RestaurantReviewListRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.getRestaurantReviews(authorization, restaurantId, dto));
    }

    @PostMapping("/restaurants/{restaurantId}/reviews/")
    public ApiResponse<RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse> createRestaurantReview(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @RequestBody RestaurantReviewCreateReqDTO.RestaurantReviewCreateRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.createRestaurantReview(authorization, restaurantId, dto));
    }
}
