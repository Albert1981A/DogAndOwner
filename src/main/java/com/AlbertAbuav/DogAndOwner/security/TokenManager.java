package com.AlbertAbuav.DogAndOwner.security;

import com.AlbertAbuav.DogAndOwner.serviceImpl.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenManager {

    @Autowired
    private Map<String, Information> map;

    public String addToken(ClientService clientService) {
        String token = UUID.randomUUID().toString();
        Information information = Information.builder()
                .clientService(clientService)
                .time(LocalDateTime.now())
                .build();
        map.put(token, information);
        return token;
    }

    public void deleteToken(String token) {
        map.remove(token);
    }

    public boolean isExist(String token) {
        return map.get(token) != null;
    }

    public void removeExpired() {
        //map.entrySet().removeIf(entry -> entry.getValue().getTime().isBefore(LocalDateTime.now().minusMinutes(10)));
        map.entrySet().removeIf(Information::removeTokensEvery10Mimuts);
    }
}
