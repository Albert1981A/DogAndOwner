package com.AlbertAbuav.DogAndOwner.security;

import com.AlbertAbuav.DogAndOwner.serviceImpl.ClientService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Information {

    private ClientService clientService;
    private LocalDateTime time;

    public static boolean removeTokensEvery10Mimuts(Map.Entry<String, Information> entry) {
        return entry.getValue().getTime().isBefore(LocalDateTime.now().minusMinutes(10));
    }

}
