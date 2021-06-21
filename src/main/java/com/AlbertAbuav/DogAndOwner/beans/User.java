package com.AlbertAbuav.DogAndOwner.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Dog> dogs;



}
