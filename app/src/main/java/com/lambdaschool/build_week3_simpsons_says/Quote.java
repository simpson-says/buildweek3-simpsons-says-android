package com.lambdaschool.build_week3_simpsons_says;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Quote implements Serializable {
    private int id;
    private String character;
    private String quote;
    private int season;
    private int episode;
    private String title;

    public Quote(int id, String character, String quote) {
        this.id = id;
        this.character = character;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s: %s", getCharacter(), getQuote());
    }
}
