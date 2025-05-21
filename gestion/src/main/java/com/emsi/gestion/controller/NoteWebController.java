package com.emsi.gestion.controller;

import org.springframework.ui.Model;
import com.emsi.gestion.entity.Note;
import com.emsi.gestion.service.EtudiantService;
import com.emsi.gestion.service.ModuleService;
import com.emsi.gestion.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteWebController {

    private final NoteService noteService;
    private final EtudiantService etudiantService;
    private final ModuleService moduleService;

    public NoteWebController(NoteService noteService, EtudiantService etudiantService, ModuleService moduleService) {
        this.noteService = noteService;
        this.etudiantService = etudiantService;
        this.moduleService = moduleService;
    }

    @GetMapping
    public String listeNotes(Model model) {
        model.addAttribute("notes", noteService.getAll());
        return "notes";
    }

    @GetMapping("/ajouter")
    public String showForm(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiantService.getAll());
        model.addAttribute("modules", moduleService.getAll());
        return "ajouter-note";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Note note = noteService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID invalide"));
        model.addAttribute("note", note);
        model.addAttribute("etudiants", etudiantService.getAll());
        model.addAttribute("modules", moduleService.getAll());
        return "ajouter-note";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/notes";
    }
    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note) {
        noteService.save(note);
        return "redirect:/notes";
    }

}

