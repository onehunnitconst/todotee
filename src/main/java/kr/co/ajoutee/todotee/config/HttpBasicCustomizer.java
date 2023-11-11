package kr.co.ajoutee.todotee.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;

public class HttpBasicCustomizer implements Customizer<HttpBasicConfigurer<HttpSecurity>> {

    @Override
    public void customize(HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer) {
        httpSecurityHttpBasicConfigurer.disable();
    }
}
