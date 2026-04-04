package com.example.umcdongdong2.domain.user.entity.mapping;


import com.example.umcdongdong2.domain.user.entity.Food;
import com.example.umcdongdong2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodTaste {

    @EmbeddedId
    private FoodTasteId foodTasteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_food")
    @JoinColumn(name = "id_food")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_user")
    @JoinColumn(name = "id_user")
    private User user;

    @Builder
    public FoodTaste(Food food, User user) {
        this.foodTasteId = new FoodTasteId(food.getId(), user.getId());
        this.food = food;
        this.user = user;
    }
}
