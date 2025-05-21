package com.emsi.gestion.service;

import java.util.Optional;
import com.emsi.gestion.entity.Professeur;
import com.emsi.gestion.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {

    private final ProfesseurRepository repo;

    public ProfesseurService(ProfesseurRepository repo) {
        this.repo = repo;
    }

    public List<Professeur> getAll() {
        return repo.findAll();
    }

    public Professeur save(Professeur p) {
        return repo.save(p);
    }

    // ✅ À ajouter pour corriger l’erreur de "findById"
    public Optional<Professeur> findById(Long id) {
        return repo.findById(id);
    }

    // ✅ À ajouter pour corriger l’erreur de "delete"
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

