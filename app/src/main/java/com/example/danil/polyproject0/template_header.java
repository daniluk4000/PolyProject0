package com.example.danil.polyproject0;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class template_header  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
    }
}
