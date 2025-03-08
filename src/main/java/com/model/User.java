package com.model;

public class User {
    private int id;
    private String email,nom;
    private String motDePasse;
    private Role role;

    public User() {}

    public User(String email,String nom, String motDePasse, Role role) {
        this.email = email;
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User(int id, String email, String nom, String motDePasse, Role role) {
        this.id = id;
        this.email = email;
        this.nom = nom;

        this.motDePasse = motDePasse;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", motDePasse='[PROTECTED]'" +
                ", role=" + role +
                '}';
    }
}
