package com.project.learnup.learnUpAPI.configerations;

import com.project.learnup.learnUpAPI.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return  http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->{auth.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole(String.valueOf(Role.ADMIN))
                        .requestMatchers("/user/**").hasAnyRole(String.valueOf(Role.USER),String.valueOf(Role.ADMIN))
                        .requestMatchers("/student/**").hasRole(String.valueOf(Role.STUDENT))
                        .requestMatchers("/instructor").hasRole(String.valueOf(Role.INSTRUCTOR))
                        .anyRequest().authenticated();})
//                .oauth2ResourceServer((oauth2) -> oauth2
//                        .jwt(jwt ->jwt
//                                .jwtAuthenticationConverter(jwtAuthenticationConverter()))
//                )
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())

                .build();

    }



}
