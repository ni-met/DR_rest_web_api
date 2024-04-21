package com.example.diningReviewApi.models;

import lombok.Getter;

@Getter
public class DiningReviewDTO {
    private String restaurantName;
    private String username;
    private String commentary;
    private Double foodScore;
    private Double serviceScore;
    private Double atmosphereScore;
}
