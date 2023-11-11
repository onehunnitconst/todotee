package kr.co.ajoutee.todotee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegisterUserDto {
    private String name;
    private LocalDate birthday;
    private String userId;
    private String password;
}
