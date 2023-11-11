package kr.co.ajoutee.todotee.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

public class CsrfCustomizer implements Customizer<CsrfConfigurer<HttpSecurity>> {
    @Override
    public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
        httpSecurityCsrfConfigurer.disable();
    }
}
