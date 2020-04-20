package com.lambdaschool.build_week3_simpsons_says;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    private int image;

    public Character(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
