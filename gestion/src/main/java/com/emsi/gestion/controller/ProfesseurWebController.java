package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Professeur;
import com.emsi.gestion.service.ProfesseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professeurs")
public class ProfesseurWebController {

    private final ProfesseurService service;

    public ProfesseurWebController(ProfesseurService service) {
        this.service = service;
    }

    @GetMapping
    public String listeProfesseurs(Model model) {
        model.addAttribute("professeurs", service.getAll());
        return "professeurs";
    }

    @GetMapping("/ajouter")
    public String showForm(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "ajouter-professeur";
    }

    @PostMapping("/ajouter")
    public String addProfesseur(@ModelAttribute Professeur professeur) {
        service.save(professeur);
        return "redirect:/professeurs";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Professeur p = service.findById(id).orElseThrow(() -> new IllegalArgumentException("ID invalide"));
        model.addAttribute("professeur", p);
        return "ajouter-professeur";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Professeur professeur) {
        professeur.setId(id);
        service.save(professeur);
        return "redirect:/professeurs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/professeurs";
    }
}

