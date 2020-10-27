package com.example.proyecto_cartas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout fondo;
    ImageButton botonMayor, botonMenor;
    int[] cartas;
    int aleatorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        instancias();
        acciones();
        aleatorio = (int) (Math.random() * 12);
        //Log.v("aleatorio", String.valueOf(aleatorio));
        fondo.setBackgroundResource(cartas[aleatorio]);

    }

    private void acciones() {
        botonMayor.setOnClickListener(this);
        botonMenor.setOnClickListener(this);
    }

    private void instancias() {
        fondo = findViewById(R.id.fondo_cartas);
        cartas = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
                R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9,
                R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13};
        botonMayor = findViewById(R.id.boton_mayor);
        botonMayor = findViewById(R.id.boton_menor);


    }

    @Override
    public void onClick(View v) {
        int aleatorioNuevo = (int) (Math.random() * 12);
        switch(v.getId()){
            case R.id.boton_menor:
                if(aleatorio>aleatorioNuevo){
                    fondo.setBackgroundResource(cartas[aleatorioNuevo]);
                    aleatorio=aleatorioNuevo;

                }else{
                    finish();
                }

                break;
            case R.id.boton_mayor:
                if(aleatorio<aleatorioNuevo){
                    fondo.setBackgroundResource(cartas[aleatorioNuevo]);
                    aleatorio=aleatorioNuevo;

                }else{
                    Intent intent = new Intent();
                    intent.putExtra("valor",2);
                    setResult(0,intent);
                    finish();
                }
                break;
        }
    }
}