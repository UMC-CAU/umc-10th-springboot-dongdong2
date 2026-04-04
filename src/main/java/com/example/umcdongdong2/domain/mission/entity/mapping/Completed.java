package com.example.umcdongdong2.domain.mission.entity.mapping;

import com.example.umcdongdong2.domain.mission.entity.Mission;
import com.example.umcdongdong2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Completed {

    @EmbeddedId
    private CompletedId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("missionId")
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Completed(Mission mission, User user) {
        this.id = new CompletedId(mission.getId(), user.getId());
        this.mission = mission;
        this.user = user;
    }
}