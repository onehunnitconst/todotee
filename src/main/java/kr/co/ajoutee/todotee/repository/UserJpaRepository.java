package kr.co.ajoutee.todotee.repository;

import kr.co.ajoutee.todotee.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByUserEntityByUserId(String userId);
}
