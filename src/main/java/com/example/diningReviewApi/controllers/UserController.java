package com.example.diningReviewApi.controllers;

import com.example.diningReviewApi.entities.User;
import com.example.diningReviewApi.models.UserDTO;
import com.example.diningReviewApi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.showAllUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserDTO userDTO){
        if(userDTO == null) return null;

        User newUser = new User(userDTO);
        newUser = userRepository.save(newUser);
        return newUser;
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUserById(@PathVariable(name="id") Long id){
        Optional<User> userToDeleteOptional = userRepository.findById(id);

        if(!userToDeleteOptional.isPresent()) return null;

        User userToDelete = userToDeleteOptional.get();
        this.userRepository.delete(userToDelete);

        return userToDelete;
    }
}
