package com.example.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBotones, btnOtros, btnListas, btnListasPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnBotones.setOnClickListener(this);
        btnListas.setOnClickListener(this);
        btnListasPerso.setOnClickListener(this);
        btnOtros.setOnClickListener(this);
    }

    private void instancias() {
        btnBotones = findViewById(R.id.botonBotones);
        btnListasPerso = findViewById(R.id.botonListaPersonalizada);
        btnListas = findViewById(R.id.botonListas);
        btnOtros = findViewById(R.id.botonOtros);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.botonBotones:
                intent=new Intent(getApplicationContext(),BotonesActivity.class);
                break;
            case R.id.botonListaPersonalizada:
                intent=new Intent(getApplicationContext(),ListasPersoActivity.class);
                break;
            case R.id.botonOtros:
                intent=new Intent(getApplicationContext(),OtrosActivity.class);
                break;
            case R.id.botonListas:
                intent=new Intent(getApplicationContext(),ListasActivity.class);
                break;
        }
        startActivity(intent);
    }
}