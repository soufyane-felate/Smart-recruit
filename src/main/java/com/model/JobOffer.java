package com.model;

import java.time.LocalDate;

public class JobOffer {
    int id;
    private String title;
    private String description;
    LocalDate date = LocalDate.now();

    public  void setDate(LocalDate date){this.date = date;}
    public LocalDate getDate(){
        return date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
