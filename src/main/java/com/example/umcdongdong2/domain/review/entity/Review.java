package com.example.umcdongdong2.domain.review.entity;


import com.example.umcdongdong2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Float star;

    @Column(nullable = false)
    private String review_content;

    @Column(nullable = true )
    private String reply_content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
}
