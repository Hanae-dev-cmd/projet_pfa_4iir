package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Module;
import com.emsi.gestion.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modules")
public class ModuleWebController {

    private final ModuleService service;

    public ModuleWebController(ModuleService service) {
        this.service = service;
    }

    @GetMapping
    public String liste(Model model) {
        model.addAttribute("modules", service.getAll());
        return "modules";
    }

    @GetMapping("/ajouter")
    public String showForm(Model model) {
        model.addAttribute("module", new Module());
        return "ajouter-module";
    }

    @PostMapping("/ajouter")
    public String add(@ModelAttribute Module module) {
        service.save(module);
        return "redirect:/modules";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Module m = service.findById(id).orElseThrow(() -> new IllegalArgumentException("ID invalide"));
        model.addAttribute("module", m);
        return "ajouter-module";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Module module) {
        module.setId(id);
        service.save(module);
        return "redirect:/modules";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/modules";
    }
}


