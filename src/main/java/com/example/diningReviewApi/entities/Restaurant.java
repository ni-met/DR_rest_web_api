package com.example.diningReviewApi.entities;

import com.example.diningReviewApi.models.RestaurantDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restaurants")
public class Restaurant {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column(name="NAME", nullable = false, length=45, unique = true)
    @Getter @Setter private String name;

    @Column(name="ADDRESS", nullable = false, length=45)
    @Getter @Setter private String address;

    @Column(name="PHONE_NUMBER", nullable = false, length = 10, unique = true)
    @Getter @Setter private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "CUISINE_TYPE", referencedColumnName = "ID")
    @Getter @Setter private Cuisine cuisineId;

    public enum PriceRange{
        $, $$, $$$, $$$$
    }
    @Column(name="PRICE_RANGE", nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private PriceRange priceRange;

    @Column(name="FOOD_SCORE")
    @Getter @Setter private Double foodScore;

    @Column(name="SERVICE_SCORE")
    @Getter @Setter private Double serviceScore;

    @Column(name="ATMOSPHERE_SCORE")
    @Getter @Setter private Double atmosphereScore;

    private Double calculateOverallScore(){
        if(overallScore != null) return (foodScore + serviceScore + atmosphereScore) / 3;

        return null;
    }

    @Column(name="OVERALL_SCORE")
    @Getter private Double overallScore = calculateOverallScore();

    public Restaurant (RestaurantDTO restaurantDTO, Cuisine cuisine){
        this.name = restaurantDTO.getName();
        this.address = restaurantDTO.getAddress();
        this.phoneNumber = restaurantDTO.getPhoneNumber();
        this.cuisineId = cuisine;
        this.priceRange = restaurantDTO.getPriceRange();
    }
    public Restaurant(){}
}

