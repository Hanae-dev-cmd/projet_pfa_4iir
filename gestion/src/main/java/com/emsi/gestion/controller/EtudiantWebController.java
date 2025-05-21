package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Etudiant;
import com.emsi.gestion.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
public class EtudiantWebController {

    private final EtudiantService service;

    public EtudiantWebController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping
    public String afficherEtudiants(Model model) {
        model.addAttribute("etudiants", service.getAll());
        return "etudiants";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "ajouter-etudiant";
    }

    @PostMapping("/ajouter")
    public String ajouterEtudiant(@ModelAttribute Etudiant etudiant) {
        service.save(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerEtudiant(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/etudiants";
    }
}
