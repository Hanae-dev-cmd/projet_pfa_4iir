package com.emsi.gestion.controller;

import org.springframework.ui.Model;

import com.emsi.gestion.entity.Etudiant;
import com.emsi.gestion.service.EtudiantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import com.emsi.gestion.entity.Etudiant;
import com.emsi.gestion.service.EtudiantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Pour les APIs JSON
@RequestMapping("/api/etudiants") // Préfixe "/api"
public class EtudiantController {

    private final EtudiantService service;

    // Injection du service via le constructeur
    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etudiant> getAll() { // Correction de "getALL" à "getAll"
        return service.getAll(); // Retourne du JSON
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant e) {
        return service.save(e); // Retourne du JSON
    }

    // Partie Vue (Thymeleaf)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Etudiant etudiant = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID invalide : " + id));

        model.addAttribute("etudiant", etudiant);
        return "ajouter-etudiant";
    }

    @PostMapping("/etudiants/update/{id}")
    public String updateEtudiant(@PathVariable Long id, @ModelAttribute Etudiant etudiant) {
        etudiant.setId(id); // Assure que l’ID reste le même
        service.save(etudiant);// Sauvegarde ou met à jour
        return "redirect:/etudiants"; // Redirige vers la liste
    }

}


