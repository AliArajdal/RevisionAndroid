package com.ali.revision.model;

import java.util.Date;

public class Personne {
    private int id;
    private int image;
    private String name;
    private String email;

    public Personne(int id, int image, String name, String email) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
