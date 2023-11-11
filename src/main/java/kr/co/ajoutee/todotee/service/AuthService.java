package kr.co.ajoutee.todotee.service;

import kr.co.ajoutee.todotee.domain.UserEntity;
import kr.co.ajoutee.todotee.dto.JwtTokenPairDto;
import kr.co.ajoutee.todotee.dto.LoginUserDto;
import kr.co.ajoutee.todotee.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;

    public UserEntity register(RegisterUserDto body) {
        return userService.create(body);
    }

    public JwtTokenPairDto login(LoginUserDto form) {
        final UserEntity user = userService.getUserByUserId(form.getUserId());

        final boolean isPasswordCorrect = passwordEncoder.matches(form.getPassword(), user.getPassword());

        if (!isPasswordCorrect) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new JwtTokenPairDto();
    }

    public String encode() {
        String raw = "asdf";
        return passwordEncoder.encode(raw);
    }
}
