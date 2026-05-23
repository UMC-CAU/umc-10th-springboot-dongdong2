package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

public class UserLoginResDTO {

    @Builder
    public record UserLoginResponse(
            String accessToken,
            Long userId
    ) {}
}
