package com.AlbertAbuav.DogAndOwner.serviceImpl;

import com.AlbertAbuav.DogAndOwner.beans.Dog;
import com.AlbertAbuav.DogAndOwner.service.CustomerService;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@Data
public class CustomerServiceImpl extends ClientService implements CustomerService {

    private int customerID;

    @Override
    public boolean login(String email, String password) {
        boolean check = true;
        if(check) {
            this.customerID = findIdByEmailAndPassword(email, password);
        }
        return true;
    }

    @Override
    public int findIdByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).getId();
    }

    @Override
    public Dog getSingleDogById(int id) {
        return dogRepository.getOne(id);
    }


}
