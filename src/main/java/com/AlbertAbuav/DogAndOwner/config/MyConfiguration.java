package com.AlbertAbuav.DogAndOwner.config;

import com.AlbertAbuav.DogAndOwner.security.Information;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfiguration {

    @Bean
    public Map<String, Information> crateMap() {
        return new HashMap<>();
    }

}
