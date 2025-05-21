package com.emsi.gestion.service;

import java.util.Optional;

import com.emsi.gestion.entity.Etudiant;
import com.emsi.gestion.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantRepository repo;

    public EtudiantService(EtudiantRepository repo) {
        this.repo = repo;
    }

    public List<Etudiant> getAll() {
        return repo.findAll();
    }

    public Etudiant save(Etudiant e) {
        return repo.save(e);
    }

    // Ajoutez cette nouvelle méthode
    public Optional<Etudiant> findById(Long id) {
        return repo.findById(id);

    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }


}

