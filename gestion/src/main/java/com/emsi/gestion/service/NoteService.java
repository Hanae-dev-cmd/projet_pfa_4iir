package com.emsi.gestion.service;

import com.emsi.gestion.entity.Note;
import com.emsi.gestion.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note> getAll() {
        return repo.findAll();
    }

    public Note save(Note n) {
        return repo.save(n);
    }

    public Optional<Note> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

