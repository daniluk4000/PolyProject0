package com.example.danil.polyproject0;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private EditText password;
    public final String APP_PREFERENCES = "login_save";
    public final String APP_PREFERENCES_LOGIN = "0";
    SharedPreferences mLogin;
    public void proceedLogin(View view) {
        if(password.getText().toString().equals("admin")) {
            try {
                SharedPreferences.Editor editor = mLogin.edit();
                editor.putString(APP_PREFERENCES_LOGIN, "1");
                editor.apply();
                Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, FilmsList.class);
                startActivity(i);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Произошла неизвестная ошибка!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Ошибка входа!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mLogin = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        if(mLogin.contains(APP_PREFERENCES_LOGIN)) {
            Intent i = new Intent(this, FilmsList.class);
            startActivity(i);
        } else {
            setContentView(R.layout.activity_main);
        }

        password = (EditText) findViewById(R.id.password_text);
    }
}





