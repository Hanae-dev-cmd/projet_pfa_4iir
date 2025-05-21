package com.emsi.gestion.repository;

import com.emsi.gestion.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

