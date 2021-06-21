package com.AlbertAbuav.DogAndOwner.serviceImpl;

import com.AlbertAbuav.DogAndOwner.beans.Dog;
import com.AlbertAbuav.DogAndOwner.service.ClinicService;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl extends ClientService implements ClinicService {

    @Override
    public boolean login(String email, String password) {
        return true;
    }

    @Override
    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public void deleteDog(int id) {
        dogRepository.deleteById(id);
    }


}
