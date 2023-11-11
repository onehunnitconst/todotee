package kr.co.ajoutee.todotee.service;

import kr.co.ajoutee.todotee.domain.UserEntity;
import kr.co.ajoutee.todotee.dto.LoginUserDto;
import kr.co.ajoutee.todotee.dto.RegisterUserDto;
import kr.co.ajoutee.todotee.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserJpaRepository userJpaRepository;

    public UserEntity create(RegisterUserDto body) {
        final String encodedPassword = passwordEncoder.encode(body.getPassword());
        final UserEntity entity = UserEntity.builder()
                .name(body.getName())
                .userId(body.getUserId())
                .password(encodedPassword)
                .birthday(body.getBirthday())
                .build();
        return userJpaRepository.save(entity);
    }

    public UserEntity getUserByUserId(String userId) {
        final UserEntity entity = userJpaRepository.findByUserEntityByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return entity;
    }

    public UserEntity getUser(Long id) {
        final UserEntity entity = userJpaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return entity;
    }
}
