package com.emsi.gestion.repository;

import com.emsi.gestion.entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    }


