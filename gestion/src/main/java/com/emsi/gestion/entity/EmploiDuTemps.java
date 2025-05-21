package com.emsi.gestion.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class EmploiDuTemps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jour; // Ex : Lundi, Mardi

    private LocalTime heureDebut;
    private LocalTime heureFin;

    private String salle;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJour() { return jour; }
    public void setJour(String jour) { this.jour = jour; }

    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }

    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }

    public String getSalle() { return salle; }
    public void setSalle(String salle) { this.salle = salle; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }
}

