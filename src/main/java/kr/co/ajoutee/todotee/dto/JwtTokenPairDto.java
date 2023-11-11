package kr.co.ajoutee.todotee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtTokenPairDto {
    private String accessToken;
    private String refreshToken;
}
