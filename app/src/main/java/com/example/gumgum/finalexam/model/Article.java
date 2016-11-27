package com.example.gumgum.finalexam.model;


public class Article {

    private int id;
    private String title;
    private String description;
    private boolean visible;
    private String categorie;

    public Article(){}

    public Article(String title, String description, boolean visible, String categorie) {
        this.title = title;
        this.description = description;
        this.visible = visible;
        this.categorie = categorie;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Titre : " +title +"\n"+"Categories : "+categorie;
    }
}
