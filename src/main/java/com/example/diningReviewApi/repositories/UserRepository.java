package com.example.diningReviewApi.repositories;

import com.example.diningReviewApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u ORDER BY u.username")
    List<User> showAllUsers();

    User findUserByUsernameEquals(String username);
}
