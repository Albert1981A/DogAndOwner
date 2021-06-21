package com.AlbertAbuav.DogAndOwner.service;

import com.AlbertAbuav.DogAndOwner.beans.Dog;

public interface CustomerService {

    int findIdByEmailAndPassword(String email, String password);

    Dog getSingleDogById(int id);
}
