package com.example.diningReviewApi.repositories;
import com.example.diningReviewApi.entities.DiningReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
    @Query("SELECT d FROM DiningReview d WHERE d.status = :status ORDER BY d.restaurant.name")
    List<DiningReview> showAllDiningReviews(DiningReview.ReviewStatus status);

    List<DiningReview> findDiningReviewsByRestaurant_NameStartingWithAndStatusEquals(String restaurantName,
                                                                                     DiningReview.ReviewStatus status);

    DiningReview findDiningReviewById(Long id);

    @Modifying
    @Query("UPDATE DiningReview d SET d.status = :status WHERE d.id = :id")
    void updateDiningReviewStatusById(Long id, DiningReview.ReviewStatus status);

    List<DiningReview> findDiningReviewsByAuthor_NameStartingWithAndStatusOrderByAuthor(String authorName, DiningReview.ReviewStatus status);

    List<DiningReview> findDiningReviewsByAuthor_UsernameStartingWithAndStatusOrderByAuthor(String authorUsername, DiningReview.ReviewStatus status);

    List<DiningReview> findDiningReviewsByFoodScoreGreaterThanAndStatusOrderByFoodScoreDesc(Double score, DiningReview.ReviewStatus status);

    List<DiningReview> findDiningReviewsByServiceScoreGreaterThanAndStatusOrderByServiceScoreDesc(Double score, DiningReview.ReviewStatus status);
    List<DiningReview> findDiningReviewsByAtmosphereScoreGreaterThanAndStatusOrderByAtmosphereScoreDesc(Double score, DiningReview.ReviewStatus status);
}
