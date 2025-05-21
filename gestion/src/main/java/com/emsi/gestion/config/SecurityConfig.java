package com.emsi.gestion.config;

import com.emsi.gestion.service.CustomUserDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/").permitAll() // ✅ Ajoute cette ligne ici
                        .requestMatchers("/api/etudiants/**").hasRole("ADMIN")
                        .requestMatchers("/api/professeurs/**").hasAnyRole("ADMIN", "PROFESSEUR")
                        .requestMatchers("/api/modules/**").hasAnyRole("ADMIN", "PROFESSEUR")
                        .requestMatchers("/api/notes/**").hasAnyRole("ADMIN", "PROFESSEUR")

                        .requestMatchers("/api/emplois/**").hasAnyRole("ADMIN", "PROFESSEUR")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/", true) // ✅ redirige automatiquement après login
                )

                .logout(logout -> logout.permitAll())
                .build(); // ✅ C’est obligatoire pour finaliser la config
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utilise BCrypt pour le hachage des mots de passe
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Configure le gestionnaire d'authentification
    }
}
