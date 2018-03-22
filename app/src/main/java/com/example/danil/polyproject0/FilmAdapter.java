package com.example.danil.polyproject0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends BaseAdapter {
    private List<FilmItem> films;
    private Context context;
    private LayoutInflater inflater;

    public FilmAdapter(List<FilmItem> films, Context context) {
        this.films = films;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View localeView = view;
        FilmItem film = getFilmItem(i);

        if (localeView == null) {
            localeView = inflater.inflate(R.layout.film_item, viewGroup, false);
        }

        ImageView imageView = localeView.findViewById(R.id.film_imageView);
        imageView.setImageResource(film.getPosterId());

        TextView nameTextView = localeView.findViewById(R.id.film_name_textView);
        nameTextView.setText(film.getFilmName());

        TextView countryTextView = localeView.findViewById(R.id.film_country_textView);
        countryTextView.setText(film.getFilmCountry());

        TextView rateTextView = localeView.findViewById(R.id.rate_film_TextView);
        rateTextView.setText(film.getFilmRate());

        return localeView;
    }

    private FilmItem getFilmItem(int position) {
        return (FilmItem) getItem(position);
    }
}
