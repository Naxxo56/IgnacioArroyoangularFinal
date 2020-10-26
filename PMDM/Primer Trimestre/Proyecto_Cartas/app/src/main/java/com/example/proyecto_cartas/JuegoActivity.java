package com.example.proyecto_cartas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

public class JuegoActivity extends AppCompatActivity {
    private Button botonAbajoNo, botonAbajoPulsado, botonArribaPulsado, botonArribaNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        instancias();
        acciones();
    }

    private void acciones() {
    }

    private void instancias() {
    }
}