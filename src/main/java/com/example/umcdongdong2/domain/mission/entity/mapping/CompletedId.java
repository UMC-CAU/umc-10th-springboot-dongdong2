package com.example.umcdongdong2.domain.mission.entity.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompletedId implements Serializable {

    @Column(name = "mission_id")
    private Long missionId;

    @Column(name = "user_id")
    private Long userId;

    public CompletedId(Long missionId, Long userId) {
        this.missionId = missionId;
        this.userId = userId;
    }
}