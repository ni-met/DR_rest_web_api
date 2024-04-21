package com.example.diningReviewApi.controllers;

import com.example.diningReviewApi.entities.Cuisine;
import com.example.diningReviewApi.repositories.CuisineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
    private final CuisineRepository cuisineRepository;

    public CuisineController(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping("/all")
    public List<Cuisine> getAllCuisines(){
        return cuisineRepository.showAllCuisines();
    }

    @PostMapping("/add")
    public Cuisine addCuisine(@RequestParam String cuisineType){
        if(cuisineType == null) return null;

        Cuisine newCuisine = new Cuisine(cuisineType);
        newCuisine = cuisineRepository.save(newCuisine);
        return newCuisine;
    }

    @DeleteMapping("/delete/{id}")
    public Cuisine deleteCuisineById(@PathVariable(name="id") Long id){
        Optional<Cuisine> cuisineToDeleteOptional = cuisineRepository.findById(id);

        if(!cuisineToDeleteOptional.isPresent()) return null;

        Cuisine cuisineToDelete = cuisineToDeleteOptional.get();
        this.cuisineRepository.delete(cuisineToDelete);

        return cuisineToDelete;
    }
}
