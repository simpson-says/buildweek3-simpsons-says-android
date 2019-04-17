package com.lambdaschool.build_week3_simpsons_says;

import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;

import java.io.Serializable;
import java.util.Locale;

public class Quote implements Serializable {
    private int id;
    private String character;
    private String quote;
    private String title;
    private int season;
    private int episode;

    public Quote(int id, String character, String quote, String title, int season, int episode) {
        this.id = id;
        this.character = character;
        this.quote = quote;
        this.title = title;
        this.season = season;
        this.episode = episode;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public SpannableStringBuilder toVerboseString() {
        SpannableString stringSeason = new SpannableString(String.format(Locale.US, "Season: %d\n", getSeason()));
        SpannableString stringEpisode = new SpannableString(String.format(Locale.US, "Episode: %d\n", getEpisode()));
        SpannableString stringTitle = new SpannableString(String.format(Locale.US, "Title: %s\n", getTitle()));
        SpannableString stringCharacter = new SpannableString(String.format(Locale.US, "Character: %s\n", getCharacter()));
        SpannableString stringQuote = new SpannableString(String.format(Locale.US, "Quote: %s", getQuote()));

        stringSeason.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringEpisode.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringTitle.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringCharacter.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringQuote.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return new SpannableStringBuilder().append(stringSeason).append(stringEpisode).append(stringTitle).append(stringCharacter).append(stringQuote);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.US, "%s: %s", getCharacter(), getQuote());
    }
}
