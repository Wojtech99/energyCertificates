package com.example.energyCertificates.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request
                .requestMatchers("/**").permitAll()
                .requestMatchers("/static/userFront/**").permitAll()
                .requestMatchers("/static/clientFront/**").permitAll()
                .anyRequest().permitAll());

        httpSecurity.formLogin(login -> login.loginPage("/login")
                .permitAll());

        httpSecurity.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**",
                HttpMethod.GET.name()))
                .logoutSuccessUrl("/")
        );
        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
