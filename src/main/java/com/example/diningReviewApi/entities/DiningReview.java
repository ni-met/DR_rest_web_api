package com.example.diningReviewApi.entities;

import com.example.diningReviewApi.models.DiningReviewDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="reviews")
public class DiningReview {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", referencedColumnName = "ID", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="AUTHOR", referencedColumnName = "ID")
    private User author;

    @Column(name="PUBLISHED_ON", nullable = false)
    private Timestamp publishedOn;

    public enum ReviewStatus{
        PENDING, ACCEPTED, REJECTED
    }
    @Column(name="STATUS", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    @Column(name="COMMENTARY")
    private String commentary;

    @Column(name="FOOD_SCORE", nullable = false)
    private Double foodScore;

    @Column(name="SERVICE_SCORE", nullable = false)
    private Double serviceScore;

    @Column(name="ATMOSPHERE_SCORE", nullable = false)
    private Double atmosphereScore;

    public DiningReview(DiningReviewDTO diningReviewDTO, Restaurant restaurant, User user){
        this.restaurant = restaurant;
        this.author = user;
        this.publishedOn = new Timestamp(System.currentTimeMillis());
        this.status = ReviewStatus.PENDING;
        this.commentary = diningReviewDTO.getCommentary();
        this.foodScore = diningReviewDTO.getFoodScore();
        this.serviceScore = diningReviewDTO.getServiceScore();
        this.atmosphereScore = diningReviewDTO.getAtmosphereScore();
    }
    public DiningReview(){}
}
