package com.example.proyecto_cartas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity  {
    private Button botonJugar;
    private CheckBox checkPracticar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void instancias() {
        botonJugar=findViewById(R.id.botonJugar);
        checkPracticar=findViewById(R.id.checkPracticar);
    }
}