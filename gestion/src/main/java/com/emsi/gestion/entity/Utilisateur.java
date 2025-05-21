package com.emsi.gestion.entity;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Enumération des rôles
    public enum Role {
        ETUDIANT,
        PROFESSEUR,
        ADMIN
    }

    // Méthode pour chiffrer le mot de passe
    public void setEncryptedPassword(String rawPassword) {
        this.password = new BCryptPasswordEncoder().encode(rawPassword);
    }

    // NE PAS EXPOSER LE SETTER STANDARD DU PASSWORD
    // Ce setter est réservé à JPA/Hibernate uniquement
    @SuppressWarnings("unused")
    public void setPassword(String password) {
        this.password = password;
    }

    // Getters et autres setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}