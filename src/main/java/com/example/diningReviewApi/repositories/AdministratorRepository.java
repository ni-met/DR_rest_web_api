package com.example.diningReviewApi.repositories;
import com.example.diningReviewApi.entities.Administrator;

import com.example.diningReviewApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    @Query("SELECT u FROM Administrator a JOIN User u ON a.userId.id=u.id ORDER BY u.username")
    List<User> showAllAdministrators();
}
