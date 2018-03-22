package com.example.danil.polyproject0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class PickedGenreActivity extends AppCompatActivity {
    private ListView listView;
    private List<FilmItem> items;
    SharedPreferences mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picked_genre);
        listView = findViewById(R.id.picked_genre_lustView);


        switch (getIntent().getIntExtra(GenresActivity.KEY_LAYOUT, -1)) {
            case 0:
                items = getDramaFilm();
                setTitle("Драма");
                break;
            case 1:
                items = getCartoonsFilms();
                setTitle("Мальтфильмы");
                break;
            case 2:
                items = getFantasticFilms();
                setTitle("Фантастика");
                break;
        }

        FilmAdapter adapter = new FilmAdapter(items, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FilmItem film = items.get(i);
                Intent intent = new Intent(PickedGenreActivity.this, PickedFilmActivity.class);
                intent.putExtra(Keys.FILM_NAME.name(), film.getFilmName());
                intent.putExtra(Keys.FILM_COUNTRY.name(), film.getFilmCountry());
                intent.putExtra(Keys.FILM_RATING.name(), film.getFilmRate());
                intent.putExtra(Keys.FILM_POSTER.name(), film.getPosterId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.home:
                intent = new Intent(this, FilmsList.class);
                startActivity(intent);
                return true;
            case R.id.about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.list:
                intent = new Intent(this, GenresActivity.class);
                startActivity(intent);
            case R.id.quit:
                mLogin = getSharedPreferences("login_save", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mLogin.edit();
                editor.clear();
                editor.apply();
                intent = new Intent(this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Выход выполнен!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private List<FilmItem> getDramaFilm() {
        return Arrays.asList(
                new FilmItem(
                        "Прибытие", "США", "Рейтинг: 94%", R.drawable.arrival
                ),
                new FilmItem(
                        "В центре внимания", "США", "Рейтинг: 97", R.drawable.center
                ),
                new FilmItem(
                        "Ла-Ла Ленд", "США, Гонконг", "Рейтинг: 92", R.drawable.lala
                ),
                new FilmItem(
                        "По соображениям совести",
                        "Австралия ,США", "Рейтинг: 86", R.drawable.ridge
                ),
                new FilmItem(
                        "Планета обезьян: Война",
                        "США, Канада, Новая Зеландия", "Рейтинг: 93", R.drawable.planet
                )
        );
    }

    private List<FilmItem> getCartoonsFilms() {
        return Arrays.asList(
                new FilmItem(
                        "Город героев", "США", "Рейтинг: 89", R.drawable.big
                ),
                new FilmItem(
                        "Моана", "США", "Рейтинг: 96", R.drawable.moana
                ),
                new FilmItem(
                        "Тайна Коко", "США", "Рейтинг: 96", R.drawable.koko
                )
        );
    }

    private List<FilmItem> getFantasticFilms() {
        return Arrays.asList(
                new FilmItem(
                        "Изгой-один: Звёздные войны. Истории",
                        "США", "Рейтинг: 85", R.drawable.rogue
                ),
                new FilmItem(
                        "Планета обезьян: Война",
                        "США, Канада, Новая Зеландия", "Рейтинг: 93", R.drawable.planet
                ),
                new FilmItem(
                        "Прибытие", "США", "Рейтинг: 94%", R.drawable.arrival
                )
        );
    }
}
