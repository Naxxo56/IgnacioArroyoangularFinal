package com.example.practicadialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recuperarDatos();
    }

    private void recuperarDatos() {
        getIntent().getExtras().getString("nombre");
        getIntent().getExtras().getString("fecha");
        getIntent().getExtras().getString("hora");
    }
}