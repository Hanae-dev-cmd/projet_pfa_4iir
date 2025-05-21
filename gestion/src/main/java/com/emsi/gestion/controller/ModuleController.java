package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Module;
import com.emsi.gestion.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    private final ModuleService service;

    public ModuleController(ModuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Module> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Module create(@RequestBody Module m) {
        return service.save(m);
    }
}

