package com.emsi.gestion.controller;

import com.emsi.gestion.entity.EmploiDuTemps;
import com.emsi.gestion.service.EmploiDuTempsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplois")
public class EmploiDuTempsController {

    private final EmploiDuTempsService service;

    public EmploiDuTempsController(EmploiDuTempsService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmploiDuTemps> getAll() {
        return service.getAll();
    }

    @PostMapping
    public EmploiDuTemps create(@RequestBody EmploiDuTemps emploi) {
        return service.save(emploi);
    }
}

