package com.model;

public class Candidat {
    private int id;
    private String nom,email ;

    public Candidat(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
    public Candidat() {}

    public Candidat(String nome, String email) {
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nome) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
