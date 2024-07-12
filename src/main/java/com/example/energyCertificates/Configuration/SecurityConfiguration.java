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
                .requestMatchers("userFront/**", "clientFront/**").permitAll()
                .requestMatchers("/", "/regulations", "/privacy-policy").permitAll()
                .requestMatchers("/login", "/send-email-form", "/message", "/ready/ready-form",
                        "/house/new-house-form", "/house/new-house-form/save",
                        "/flat/new-flat-form", "/flat/new-flat-form/save").permitAll()

                .requestMatchers("/delete-building/{city}/{street}/{houseNumber}/{flatNumber}/{postalCode}/{date}/{buildingType}," +
                        "/energy-performance-certificates-list", "/list-of-clients",
                        "/change-password", "/change-password/save").authenticated()

                .anyRequest().authenticated()
        );


        httpSecurity.formLogin(login -> login.loginPage("/login")
                .permitAll()
        );

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
