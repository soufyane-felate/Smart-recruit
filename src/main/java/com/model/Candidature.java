package com.model;

import java.time.LocalDate;

public class Candidature {
    private int id;
    private int idCandidat;
    private int idOffreEmploi;
    private LocalDate dateCandidature;
    private String statut;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCandidat() { return idCandidat; }
    public void setIdCandidat(int idCandidat) { this.idCandidat = idCandidat; }

    public int getIdOffreEmploi() { return idOffreEmploi; }
    public void setIdOffreEmploi(int idOffreEmploi) { this.idOffreEmploi = idOffreEmploi; }

    public LocalDate getDateCandidature() { return dateCandidature; }
    public void setDateCandidature(LocalDate dateCandidature) { this.dateCandidature = dateCandidature; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
