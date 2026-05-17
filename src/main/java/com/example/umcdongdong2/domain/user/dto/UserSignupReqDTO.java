package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

import java.util.List;

public class UserSignupReqDTO {

    @Builder
    public record UserSignupRequest(
            String name,
            String email,
            String password,
            Integer gender,
            String birth,
            String address,
            List<String> foodTypes,
            Boolean notice_marketing
    ){}
}
