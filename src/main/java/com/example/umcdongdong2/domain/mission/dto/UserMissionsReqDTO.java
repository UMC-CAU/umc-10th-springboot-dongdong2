package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class UserMissionsReqDTO {

    @Builder
    public record UserMissionsRequest(
            Long restaurantId,
            String filter
    ) {}
}
