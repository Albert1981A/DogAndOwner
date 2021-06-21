package com.AlbertAbuav.DogAndOwner.clr;

import com.AlbertAbuav.DogAndOwner.Repositories.DogRepository;
import com.AlbertAbuav.DogAndOwner.Repositories.UserRepository;
import com.AlbertAbuav.DogAndOwner.beans.Color;
import com.AlbertAbuav.DogAndOwner.beans.Dog;
import com.AlbertAbuav.DogAndOwner.beans.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Order(1)
public class Bootstrap implements CommandLineRunner {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Dog d1 = Dog.builder()
                .name("Flaffy")
                .birthday(java.sql.Date.valueOf(LocalDate.of(2000, 12,3)))
                .color(Color.BROWN)
                .weight(4.5f)
                .build();

        Dog d2 = Dog.builder()
                .name("Pappy")
                .birthday(java.sql.Date.valueOf(LocalDate.of(2002, 2,23)))
                .color(Color.BLACK)
                .weight(5.2f)
                .build();

        User u1 = User.builder()
                .firstName("Owen")
                .lastName("Kob")
                .email("owen@gmail.com")
                .password("1234")
                .dog(d1)
                .build();

        User u2 = User.builder()
                .firstName("Dov")
                .lastName("Bamba")
                .email("dov@gmail.com")
                .password("2345")
                .dog(d2)
                .build();

        userRepository.saveAll(Arrays.asList(u1, u2));

        System.out.println(userRepository.getOne(1));
        System.out.println(userRepository.getOne(2));

    }
}
