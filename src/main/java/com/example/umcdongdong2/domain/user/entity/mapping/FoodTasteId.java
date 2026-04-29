package com.example.umcdongdong2.domain.user.entity.mapping;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
    private Long id_food;

    @Column(name="id_user")
    private Long id_user;

    public FoodTasteId(Long foodId, Long userId) {
        this.id_food = foodId;
        this.id_user = userId;
    }
}
