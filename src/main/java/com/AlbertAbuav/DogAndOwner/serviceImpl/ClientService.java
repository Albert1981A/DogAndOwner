package com.AlbertAbuav.DogAndOwner.serviceImpl;

import com.AlbertAbuav.DogAndOwner.Repositories.DogRepository;
import com.AlbertAbuav.DogAndOwner.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {

    @Autowired
    protected DogRepository dogRepository;
    @Autowired
    protected UserRepository userRepository;

    public ClientService() {
    }

    public abstract boolean login(String email, String password);
}
