package com.AlbertAbuav.DogAndOwner.security;

import com.AlbertAbuav.DogAndOwner.Repositories.UserRepository;
import com.AlbertAbuav.DogAndOwner.service.ClinicService;
import com.AlbertAbuav.DogAndOwner.service.CustomerService;
import com.AlbertAbuav.DogAndOwner.serviceImpl.ClientService;
import com.AlbertAbuav.DogAndOwner.serviceImpl.ClinicServiceImpl;
import com.AlbertAbuav.DogAndOwner.serviceImpl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginManager {

    private final ApplicationContext ctx;
    private final UserRepository userRepository;
    private final TokenManager tokenManager;

    public String login(String email, String password, UserType userType){
        switch (userType){
            case CLINIC:
                ClinicService clinicService = ctx.getBean(ClinicService.class);
                if (((ClinicServiceImpl)clinicService).login(email, password)) {
                    // ==> return Token
                    return tokenManager.addToken((ClientService) clinicService);
                }
                break;
            case CUSTOMER:
                CustomerService customerService = ctx.getBean(CustomerService.class);
                if (((CustomerServiceImpl)customerService).login(email, password)) {
                    // ==> we needs to get the customer id.
                    //it is optional to do it from here:
                    // for this we need to put @Data annotation in CustomerService and do the setCustomerID
                    // ((CustomerServiceImpl)customerService).setCustomerID(userRepository.findByEmailAndPassword(email, password).getId());
                    // ==> return Token
                    return tokenManager.addToken((ClientService) customerService);
                }
                break;
        }

        throw new SecurityException("Invalid email or password");
    }
}
