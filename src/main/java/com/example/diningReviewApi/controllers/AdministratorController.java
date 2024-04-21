package com.example.diningReviewApi.controllers;

import com.example.diningReviewApi.entities.Administrator;
import com.example.diningReviewApi.entities.DiningReview;
import com.example.diningReviewApi.entities.Restaurant;
import com.example.diningReviewApi.entities.User;
import com.example.diningReviewApi.repositories.AdministratorRepository;
import com.example.diningReviewApi.repositories.DiningReviewRepository;
import com.example.diningReviewApi.repositories.RestaurantRepository;
import com.example.diningReviewApi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    private final AdministratorRepository administratorRepository;
    private final UserRepository userRepository;
    private final DiningReviewRepository diningReviewRepository;
    private final RestaurantRepository restaurantRepository;

    public AdministratorController(AdministratorRepository administratorRepository, UserRepository userRepository, DiningReviewRepository diningReviewRepository, RestaurantRepository restaurantRepository) {
        this.administratorRepository = administratorRepository;
        this.userRepository = userRepository;
        this.diningReviewRepository = diningReviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/all")
    public List<User> getAllAdministrators() {
        return administratorRepository.showAllAdministrators();
    }

    @PostMapping("/add")
    public Administrator addAdministrator(@RequestParam String username){
        if(username == null) return null;

        User user = userRepository.findUserByUsernameEquals(username);
        if (user == null) return null;

        Administrator newAdministrator = new Administrator(user);
        newAdministrator = administratorRepository.save(newAdministrator);
        return newAdministrator;
    }

    @PostMapping("/{id}/status")
    @Transactional
    public ResponseEntity<?> changeReviewStatus(@PathVariable(name="id") Long id,
                                          @RequestParam DiningReview.ReviewStatus newStatus){
        if(id == null || newStatus == null) return null;

        Optional<DiningReview> optionalDiningReview = diningReviewRepository.findById(id);
        if(optionalDiningReview.isPresent()) {
            diningReviewRepository.updateDiningReviewStatusById(id, newStatus);

            DiningReview diningReview = diningReviewRepository.findDiningReviewById(id);
            updateRestaurantScores(diningReview.getRestaurant());

            return ResponseEntity.ok().build();
        }

        return null;
    }

    private void updateRestaurantScores(Restaurant restaurant) {
        Double foodScoreAvg = restaurantRepository.calculateAverageFoodScoreByRestaurantAndStatus
                (restaurant.getId(), DiningReview.ReviewStatus.ACCEPTED);
        Double serviceScoreAvg = restaurantRepository.calculateAverageServiceScoreByRestaurantAndStatus
                (restaurant.getId(), DiningReview.ReviewStatus.ACCEPTED);
        Double atmosphereScoreAvg = restaurantRepository.calculateAverageAtmosphereScoreByRestaurantAndStatus
                (restaurant.getId(), DiningReview.ReviewStatus.ACCEPTED);

        restaurant.setFoodScore(foodScoreAvg);
        restaurant.setServiceScore(serviceScoreAvg);
        restaurant.setAtmosphereScore(atmosphereScoreAvg);
        restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public Administrator deleteAdministratorById(@PathVariable(name="id") Long id){
        Optional<Administrator> administratorToDeleteOptional = administratorRepository.findById(id);

        if(!administratorToDeleteOptional.isPresent()) return null;

        Administrator administratorToDelete = administratorToDeleteOptional.get();
        this.administratorRepository.delete(administratorToDelete);

        return administratorToDelete;
    }
}
