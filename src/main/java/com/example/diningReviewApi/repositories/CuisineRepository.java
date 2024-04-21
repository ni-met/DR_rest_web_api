package com.example.diningReviewApi.repositories;
import com.example.diningReviewApi.entities.Cuisine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Cuisine findCuisineByTypeEquals(String type);

    @Query("SELECT c FROM Cuisine c ORDER BY c.type")
    List<Cuisine> showAllCuisines();
}
