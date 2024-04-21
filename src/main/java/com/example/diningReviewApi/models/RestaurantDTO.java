package com.example.diningReviewApi.models;

import com.example.diningReviewApi.entities.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String cuisineType;
    private Restaurant.PriceRange priceRange;
}
