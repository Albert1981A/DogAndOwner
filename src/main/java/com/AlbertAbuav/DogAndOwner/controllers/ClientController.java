package com.AlbertAbuav.DogAndOwner.controllers;

import com.AlbertAbuav.DogAndOwner.controllers.model.LoginDetails;
import com.AlbertAbuav.DogAndOwner.controllers.model.LogoutDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class ClientController {

    public abstract ResponseEntity<?> login(@RequestBody LoginDetails loginDetails);
    public abstract ResponseEntity<?> logOut(@RequestBody LogoutDetails logoutDetails);

}
