package com.example.diningReviewApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="administrators")
public class Administrator {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "U_ID" , referencedColumnName = "ID")
    private User userId;

    public Administrator(User user){
        this.userId = user;
    }
    public Administrator(){}
}
