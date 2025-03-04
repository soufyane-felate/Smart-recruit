package com.model;

public class Emploi {
    private int id;
    private String titre,description,datePublication;

    public Emploi(int id, String titre, String description, String datePublication) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Emploi(String titre, String description, String datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Emploi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
}
