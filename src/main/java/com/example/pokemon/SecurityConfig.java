package com.example.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") // Admin role can access this path
                .antMatchers("/editor/**").hasRole("EDITOR") // Editor role can access this path
                .antMatchers("/", "/home", "/login", "/register").permitAll() // Public paths
                .anyRequest().authenticated() // Requires authentication for all other requests
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll() // Everyone can access login page
            .and()
            .logout()
                .permitAll(); // Allow everyone to logout
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt for password encryption
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            if ("admin".equals(username)) {
                return User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin123")) // BCrypt encrypted password
                        .roles("ADMIN")
                        .build();
            } else if ("editor".equals(username)) {
                return User.builder()
                        .username("editor")
                        .password(passwordEncoder().encode("editor123")) // BCrypt encrypted password
                        .roles("EDITOR")
                        .build();
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        };
    }
}
