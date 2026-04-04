package com.example.umcdongdong2.domain.mission.entity;


import com.example.umcdongdong2.domain.mission.entity.mapping.Completed;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_order_amount", nullable = false)
    private Integer minOrderAmount;

    @Column(nullable = false)
    private Integer reward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "mission")
    private List<Completed> completedList =  new ArrayList<>();

    @Builder
    public Mission(Integer minOrderAmount, Integer reward, Region region) {
        this.minOrderAmount = minOrderAmount;
        this.reward = reward;
        this.region = region;
    }



}
