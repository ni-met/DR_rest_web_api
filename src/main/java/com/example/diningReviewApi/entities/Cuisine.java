package com.example.diningReviewApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cuisine")
public class Cuisine {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="TYPE", nullable = false, length = 45, unique = true)
    public String type;

    public Cuisine(String cuisineType){
        this.type = cuisineType;
    }
    public Cuisine(){}
}
