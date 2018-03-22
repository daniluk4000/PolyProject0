package com.example.danil.polyproject0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GenresActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_LAYOUT = "LAYOUT";
    SharedPreferences mLogin;
    private RelativeLayout drama;
    private RelativeLayout cartoons;
    private RelativeLayout fantasstic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        drama = findViewById(R.id.dramaLayout);
        cartoons = findViewById(R.id.cartoonLayout);
        fantasstic = findViewById(R.id.fantasticLayout);

        drama.setOnClickListener(this);
        cartoons.setOnClickListener(this);
        fantasstic.setOnClickListener(this);

        setTitle("Жанры");
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

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, PickedGenreActivity.class);
        switch (view.getId()) {
            case R.id.dramaLayout:
                intent.putExtra(KEY_LAYOUT, 0);
                startActivity(intent);
                break;
            case R.id.cartoonLayout:
                intent.putExtra(KEY_LAYOUT, 1);
                startActivity(intent);
                break;
            case R.id.fantasticLayout:
                intent.putExtra(KEY_LAYOUT, 2);
                startActivity(intent);
                break;
        }
    }
}
