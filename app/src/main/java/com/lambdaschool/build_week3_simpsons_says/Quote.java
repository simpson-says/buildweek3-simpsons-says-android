package com.lambdaschool.build_week3_simpsons_says;

import android.support.annotation.NonNull;

public class Quote {
    private int id;
    private String Character;
    private String quote;

    public Quote(int id, String character, String quote) {
        this.id = id;
        Character = character;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacter() {
        return Character;
    }

    public void setCharacter(String character) {
        Character = character;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s: %s", getCharacter(), getQuote());
    }
}
