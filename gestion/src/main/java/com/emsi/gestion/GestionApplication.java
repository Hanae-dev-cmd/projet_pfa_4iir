package com.emsi.gestion;

import com.emsi.gestion.entity.Utilisateur;
import com.emsi.gestion.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UtilisateurRepository repo, PasswordEncoder encoder) {
		return args -> {
			if (repo.findByUsername("admin").isEmpty()) {
				Utilisateur admin = new Utilisateur();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("1234"));
				admin.setRole(Utilisateur.Role.ADMIN);
				repo.save(admin);
			}
		};
	}


}

