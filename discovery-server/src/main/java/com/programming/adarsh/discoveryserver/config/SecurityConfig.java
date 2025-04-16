package com.programming.adarsh.discoveryserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${app.eureka.username}")
    private String username;

    @Value("${app.eureka.password}")
    private String password;

    /**
     * Defines a UserDetailsService with in-memory authentication.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username(username).password(passwordEncoder().encode(password)).roles("USER").build();

        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(user);
    }

    /**
     * Defines the security filter chain.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).httpBasic();
        return http.build();
    }

    /**
     * Provides a password encoder (BCrypt for security).
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
