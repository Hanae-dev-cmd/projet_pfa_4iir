package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Professeur;
import com.emsi.gestion.service.ProfesseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    private final ProfesseurService service;

    public ProfesseurController(ProfesseurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professeur> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Professeur create(@RequestBody Professeur p) {
        return service.save(p);
    }
}

