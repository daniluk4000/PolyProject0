package com.example.danil.polyproject0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    SharedPreferences mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                intent = new Intent(this, FilmsList.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.about:
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
