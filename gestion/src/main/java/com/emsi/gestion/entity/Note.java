package com.emsi.gestion.entity;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cc;
    private double tp;
    private double examen;
    private Double valeur;


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    // Méthode pour calculer la moyenne
    public double getMoyenne() {
        return (cc + tp + examen) / 3;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getCc() { return cc; }
    public void setCc(double cc) { this.cc = cc; }

    public double getTp() { return tp; }
    public void setTp(double tp) { this.tp = tp; }

    public double getExamen() { return examen; }
    public void setExamen(double examen) { this.examen = examen; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }
}
