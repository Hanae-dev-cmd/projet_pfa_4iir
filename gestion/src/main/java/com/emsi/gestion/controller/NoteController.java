package com.emsi.gestion.controller;

import com.emsi.gestion.entity.Note;
import com.emsi.gestion.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return service.save(note);
    }
}

