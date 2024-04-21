package com.example.diningReviewApi.entities;

import com.example.diningReviewApi.models.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="USERNAME", nullable = false, length = 45, unique = true)
    protected String username;

    @Column(name="NAME", nullable = false, length = 45)
    private String name;

    @Column(name="PASSWORD", nullable = false, length = 45)
    @JsonIgnore
    private String password;

    @Column(name="PHONE_NUMBER", nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @Column(name="CITY", nullable = false, length = 30)
    private String city;

    public User(UserDTO userDTO){
        this.username = userDTO.getUsername();
        this.name = userDTO.getName();
        this.password = userDTO.getPassword();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.city = userDTO.getCity();
    }
    public User(){}
}
