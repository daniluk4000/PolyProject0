package com.example.danil.polyproject0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class FilmsList extends AppCompatActivity {
    SharedPreferences mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Все фильмы");
        setContentView(R.layout.activity_films);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                Intent a = new Intent(this, FilmsList.class);
                startActivity(a);
                return true;
            case R.id.about:
                return true;
            case R.id.list:
                return true;
            case R.id.quit:
                mLogin = getSharedPreferences("login_save", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mLogin.edit();
                editor.clear();
                editor.apply();
                Intent i = new Intent(this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Выход выполнен!", Toast.LENGTH_SHORT).show();
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
