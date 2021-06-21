package com.AlbertAbuav.DogAndOwner.task;

import com.AlbertAbuav.DogAndOwner.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveExpiredTokens {

    private final TokenManager tokenManager;

    @Scheduled(fixedRate = 5000) //==> will work every 5 seconds
    public void removeExpiredTokens() {
        tokenManager.removeExpired();
    }


}
