package com.example.danil.polyproject0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PickedFilmActivity extends AppCompatActivity {
    SharedPreferences mLogin;
    private TextView pickedName;
    private TextView pickedCountry;
    private TextView pickedRate;
    private ImageView pickedPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picked_film);

        pickedName = findViewById(R.id.picked_film_name);
        pickedCountry = findViewById(R.id.picked_film_country);
        pickedRate = findViewById(R.id.picked_film_rating);
        pickedPoster = findViewById(R.id.picked_film_poster);

        Intent intent = getIntent();

        if (intent != null) {
            pickedName.setText(intent.getStringExtra(Keys.FILM_NAME.name()));
            pickedCountry.setText(intent.getStringExtra(Keys.FILM_COUNTRY.name()));
            pickedRate.setText(intent.getStringExtra(Keys.FILM_RATING.name()));
            pickedPoster.setImageResource(intent.getIntExtra(Keys.FILM_POSTER.name(), 0));
        }

        setTitle(pickedName.getText().toString());
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
                finish();
                return true;
            case R.id.about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.list:
                intent = new Intent(this, GenresActivity.class);
                startActivity(intent);
                finish();
                return true;
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

}
