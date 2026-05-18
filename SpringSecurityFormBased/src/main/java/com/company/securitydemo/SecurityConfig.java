package com.company.securitydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Security Rules

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(authorize -> authorize

                        // PUBLIC URL

                        .requestMatchers("/public/**")
                        .permitAll()

                        // ADMIN URL

                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")

                        // USER URL

                        .requestMatchers("/api/user/**")
                        .hasAnyRole("USER", "ADMIN")

                        // ALL OTHER URLS

                        .anyRequest()
                        .authenticated()
                )

                .httpBasic(Customizer.withDefaults())

                .formLogin(form -> form
                        .defaultSuccessUrl(
                                "/success",
                                true
                        )
                        .permitAll()
                );

        return http.build();
    }

    // IN MEMORY USERS

    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails user = User.builder()

                .username("jiya")

                .password(
                        passwordEncoder.encode(
                                "password"
                        )
                )

                .roles("USER")

                .build();

        UserDetails admin = User.builder()

                .username("admin")

                .password(
                        passwordEncoder.encode(
                                "adminpass"
                        )
                )

                .roles("ADMIN", "USER")

                .build();

        return new InMemoryUserDetailsManager(
                user,
                admin
        );
    }

    // PASSWORD ENCODER

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}