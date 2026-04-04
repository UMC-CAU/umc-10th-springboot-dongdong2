package com.example.umcdongdong2.domain.user.entity.mapping;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodTasteId {
    @Column(name="id_food")
    private Long foodId;

    @Column(name="id_user")
    private Long userId;

    public FoodTasteId(Long foodId, Long userId) {
        this.foodId = foodId;
        this.userId = userId;
    }
}
