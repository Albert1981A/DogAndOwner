package com.AlbertAbuav.DogAndOwner.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginDetails {

    private String email;
    private String password;

}
