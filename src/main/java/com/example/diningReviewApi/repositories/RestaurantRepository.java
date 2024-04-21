package com.example.diningReviewApi.repositories;
import com.example.diningReviewApi.entities.DiningReview;
import com.example.diningReviewApi.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r ORDER BY r.name")
    List<Restaurant>   showAllRestaurants();

    List<Restaurant> findRestaurantsByNameStartingWithOrderByName(String name);
    Restaurant findRestaurantByNameEquals(String name);

    @Query("SELECT AVG(d.foodScore) FROM DiningReview d WHERE d.restaurant.id = :restaurantId AND d.status = :status")
    Double calculateAverageFoodScoreByRestaurantAndStatus(@Param("restaurantId") Long restaurantId,
                                                          @Param("status") DiningReview.ReviewStatus status);

    @Query("SELECT AVG(d.serviceScore) FROM DiningReview d WHERE d.restaurant.id = :restaurantId AND d.status = :status")
    Double calculateAverageServiceScoreByRestaurantAndStatus(@Param("restaurantId") Long restaurantId,
                                                             @Param("status") DiningReview.ReviewStatus status);

    @Query("SELECT AVG(d.atmosphereScore) FROM DiningReview d WHERE d.restaurant.id = :restaurantId AND d.status = :status")
    Double calculateAverageAtmosphereScoreByRestaurantAndStatus(@Param("restaurantId") Long restaurantId,
                                                                @Param("status") DiningReview.ReviewStatus status);

}
