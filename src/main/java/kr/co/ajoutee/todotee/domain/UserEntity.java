package kr.co.ajoutee.todotee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor
public class UserEntity extends BasicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthday;

    private String userId;

    private String password;

    @Builder
    public UserEntity(String name, LocalDate birthday, String userId, String password) {
        this.name = name;
        this.birthday = birthday;
        this.userId = userId;
        this.password = password;
    }
}
