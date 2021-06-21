package com.AlbertAbuav.DogAndOwner.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogoutDetails {

    private String token;

}
