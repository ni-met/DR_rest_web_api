package com.example.diningReviewApi.controllers;

import com.example.diningReviewApi.entities.Cuisine;
import com.example.diningReviewApi.entities.Restaurant;
import com.example.diningReviewApi.models.RestaurantDTO;
import com.example.diningReviewApi.repositories.CuisineRepository;
import com.example.diningReviewApi.repositories.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final CuisineRepository cuisineRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, CuisineRepository cuisineRepository) {
        this.restaurantRepository = restaurantRepository;
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.showAllRestaurants();
    }

    @GetMapping("/search/{name}")
    public List<Restaurant> getRestaurantsByName(
        @PathVariable(name="name") String restaurantName){
        if(restaurantName != null) {
            List<Restaurant> foundRestaurants = this.restaurantRepository.findRestaurantsByNameStartingWithOrderByName(restaurantName);
            return foundRestaurants;
        }

        return new ArrayList<>();
    }

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody RestaurantDTO restaurant){
        if(restaurant == null) return null;
        Cuisine cuisine = cuisineRepository.findCuisineByTypeEquals(restaurant.getCuisineType());

        if (cuisine == null) return null;

        Restaurant newRestaurant = new Restaurant(restaurant, cuisine);
        newRestaurant = restaurantRepository.save(newRestaurant);
        return newRestaurant;
    }

    @DeleteMapping("/delete/{id}")
    public Restaurant deleteRestaurantById(@PathVariable(name="id") Long id){
        Optional<Restaurant> restaurantToDeleteOptional = restaurantRepository.findById(id);

        if(!restaurantToDeleteOptional.isPresent()) return null;

        Restaurant restaurantToDelete = restaurantToDeleteOptional.get();
        this.restaurantRepository.delete(restaurantToDelete);

        return restaurantToDelete;
    }
}
