package com.emsi.gestion.service;

import java.util.Optional;
import com.emsi.gestion.entity.Module;
import com.emsi.gestion.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository repo;

    public ModuleService(ModuleRepository repo) {
        this.repo = repo;
    }

    public List<Module> getAll() {
        return repo.findAll();
    }

    public Module save(Module m) {
        return repo.save(m);
    }

    public Optional<Module> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

