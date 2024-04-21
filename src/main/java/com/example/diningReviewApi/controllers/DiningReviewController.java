package com.example.diningReviewApi.controllers;
import com.example.diningReviewApi.entities.DiningReview;
import com.example.diningReviewApi.entities.Restaurant;
import com.example.diningReviewApi.entities.User;
import com.example.diningReviewApi.models.DiningReviewDTO;
import com.example.diningReviewApi.repositories.DiningReviewRepository;

import com.example.diningReviewApi.repositories.RestaurantRepository;
import com.example.diningReviewApi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reviews")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public DiningReviewController(DiningReviewRepository diningReviewRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<DiningReview> showAllReviews(){
        return diningReviewRepository.showAllDiningReviews(DiningReview.ReviewStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public DiningReview addReview(@RequestBody DiningReviewDTO review){
        if(review == null) return null;

        Restaurant restaurant = restaurantRepository.findRestaurantByNameEquals(review.getRestaurantName());
        User user = userRepository.findUserByUsernameEquals(review.getUsername());

        if (restaurant == null || user == null) return null;

        DiningReview newReview = new DiningReview(review, restaurant, user);
        newReview = diningReviewRepository.save(newReview);
        return newReview;
    }

    @DeleteMapping("/delete/{id}")
    public DiningReview deleteReviewById(@PathVariable(name="id") Long id){
        Optional<DiningReview> reviewToDeleteOptional = diningReviewRepository.findById(id);

        if(!reviewToDeleteOptional.isPresent()) return null;

        DiningReview reviewToDelete = reviewToDeleteOptional.get();
        this.diningReviewRepository.delete(reviewToDelete);

        return reviewToDelete;
    }

    @GetMapping("/search/{restaurantName}")
    public List<DiningReview> getDiningReviewsByRestaurantName(
            @PathVariable(name="restaurantName") String restaurantName) {
        if (restaurantName != null) {
            return this.diningReviewRepository.findDiningReviewsByRestaurant_NameStartingWithAndStatusEquals(restaurantName,
                    DiningReview.ReviewStatus.ACCEPTED);
        }
        return new ArrayList<>();
    }

    @GetMapping("/search/by-author/{authorName}")
    public List<DiningReview> getDiningReviewByAuthorName(
            @PathVariable(name="authorName") String authorName){
        if(authorName != null){
            return this.diningReviewRepository.findDiningReviewsByAuthor_NameStartingWithAndStatusOrderByAuthor
                    (authorName, DiningReview.ReviewStatus.ACCEPTED);
        }
        return new ArrayList<>();
    }

    @GetMapping("/search/by-username/{username}")
    public List<DiningReview> getDiningReviewByUsername(
            @PathVariable(name="username") String username){
        if(username != null){
            return this.diningReviewRepository.findDiningReviewsByAuthor_UsernameStartingWithAndStatusOrderByAuthor
                    (username, DiningReview.ReviewStatus.ACCEPTED);
        }

        return new ArrayList<>();
    }

    @GetMapping("/search/by-food-score/{score}")
    public List<DiningReview> getDiningReviewByFoodScore(
            @PathVariable(name="score") Double score){
        if(score != null){
            return this.diningReviewRepository.findDiningReviewsByFoodScoreGreaterThanAndStatusOrderByFoodScoreDesc
                    (score, DiningReview.ReviewStatus.ACCEPTED);
        }

        return new ArrayList<>();
    }

    @GetMapping("/search/by-service-score/{score}")
    public List<DiningReview> getDiningReviewByServiceScore(
            @PathVariable(name="score") Double score){
        if(score != null){
            return this.diningReviewRepository.findDiningReviewsByServiceScoreGreaterThanAndStatusOrderByServiceScoreDesc
                    (score, DiningReview.ReviewStatus.ACCEPTED);
        }

        return new ArrayList<>();
    }

    @GetMapping("/search/by-atmosphere-score/{score}")
    public List<DiningReview> getDiningReviewByAtmosphereScore(
            @PathVariable(name="score") Double score){
        if(score != null){
            return this.diningReviewRepository.
                    findDiningReviewsByAtmosphereScoreGreaterThanAndStatusOrderByAtmosphereScoreDesc(score,
                            DiningReview.ReviewStatus.ACCEPTED);
        }

        return new ArrayList<>();
    }
}
