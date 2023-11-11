package kr.co.ajoutee.todotee.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.PrivateKeyBuilder;
import io.jsonwebtoken.security.SignatureAlgorithm;
import kr.co.ajoutee.todotee.domain.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {
//    @Autowired
//    private JwtService jwtService;

//    @Test
//    void sign() {
//        UserEntity user = UserEntity.builder()
//                .id(1L)
//                .userId("sangsu")
//                .password("1234")
//                .name("sangsu")
//                .birthday(LocalDate.of(1996, 01, 03))
//                .build();
//    }
//
//    @Test
//    void verify() {
//    }

    @Test
    void test() {
        SignatureAlgorithm alg = Jwts.SIG.ES512; //or ES256 or ES384
        KeyPair pair = alg.keyPair().build();
        System.out.println("pair = " + pair.getPrivate().toString());
        System.out.println("pair = " + pair.getPublic().toString());


    }
}