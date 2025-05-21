package com.emsi.gestion.service;

import com.emsi.gestion.entity.EmploiDuTemps;
import com.emsi.gestion.repository.EmploiDuTempsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploiDuTempsService {

    private final EmploiDuTempsRepository repo;

    public EmploiDuTempsService(EmploiDuTempsRepository repo) {
        this.repo = repo;
    }

    public List<EmploiDuTemps> getAll() {
        return repo.findAll();
    }

    public EmploiDuTemps save(EmploiDuTemps emploi) {
        return repo.save(emploi);
    }
}

