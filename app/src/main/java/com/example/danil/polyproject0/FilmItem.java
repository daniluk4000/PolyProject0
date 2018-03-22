package com.example.danil.polyproject0;

public class FilmItem {
    private String filmName;
    private String filmCountry;
    private String filmRate;
    private int posterId;

    public FilmItem(String filmName, String filmCountry, String filmRate, int posterId) {
        this.filmName = filmName;
        this.filmCountry = filmCountry;
        this.filmRate = filmRate;
        this.posterId = posterId;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getFilmCountry() {
        return filmCountry;
    }

    public String getFilmRate() {
        return filmRate;
    }

    public int getPosterId() {
        return posterId;
    }
}
