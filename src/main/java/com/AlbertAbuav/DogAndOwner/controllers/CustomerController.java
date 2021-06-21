package com.AlbertAbuav.DogAndOwner.controllers;

import com.AlbertAbuav.DogAndOwner.beans.Dog;
import com.AlbertAbuav.DogAndOwner.controllers.model.LoginDetails;
import com.AlbertAbuav.DogAndOwner.controllers.model.LogoutDetails;
import com.AlbertAbuav.DogAndOwner.exceptions.SecurityException01;
import com.AlbertAbuav.DogAndOwner.security.LoginManager;
import com.AlbertAbuav.DogAndOwner.security.TokenManager;
import com.AlbertAbuav.DogAndOwner.security.UserType;
import com.AlbertAbuav.DogAndOwner.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")  // ==>  http://localhost:8080/customer
@RequiredArgsConstructor
public class CustomerController extends ClientController{

    private final CustomerService customerService;
    private final LoginManager loginManager;
    private final TokenManager tokenManager;

    @PostMapping("login")
    @Override
    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) {
        String token = loginManager.login(loginDetails.getEmail(), loginDetails.getPassword(), UserType.CUSTOMER);
        return new ResponseEntity<>(token, HttpStatus.CREATED);  //==> return String token + 201
    }

    @DeleteMapping("logout")
    @Override
    public ResponseEntity<?> logOut(@RequestBody LogoutDetails logoutDetails) {
        tokenManager.deleteToken(logoutDetails.getToken());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  //==> Return 204 (ok and no content)
    }

    @GetMapping("dogs/{id}") // ==>  http://localhost:8080/customer/dogs/1  (id = 1)
    public ResponseEntity<?> getSingleDogById(@RequestHeader(value = "Authorization") String token, @PathVariable int id) throws SecurityException01 {
//        if (!tokenManager.isExist(token)) {
//            throw new SecurityException01("Token doesn't exist!");
//        }
        return new ResponseEntity<>(customerService.getSingleDogById(id), HttpStatus.OK);  //==> Return body + 200
    }

}
