package com.nacho.tema01_ciclo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonPulsar , botonPulsar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cicloVida();
        instancias();
        acciones();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ciclo_vida", "Ejecutado desde onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ciclo_vida", "Ejecutado desde onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ciclo_vida", "Ejecutado desde onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo_vida", "Ejecutado desde onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo_vida", "Ejecutado desde onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo_vida", "Ejecutado desde onRestart");
    }

    private void cicloVida() {
        Log.v("ciclo_vida", "Ejecutado desde onCreate");
    }

    private void instancias() {
        botonPulsar = this.findViewById(R.id.boton_pulsar);
        botonPulsar2 = this.findViewById(R.id.boton_pulsar2);
    }

    private void acciones() {
        /*
        botonPulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("prueba", "Esto es un ejemplo");
            }
        });
        botonPulsar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("prueba", "Esto es un ejemplo del boton 2");
            }
        });
         */
        botonPulsar.setOnClickListener(this);
        botonPulsar2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_pulsar:
                Log.v("prueba", "Esto es un ejemplo");
                break;
            case R.id.boton_pulsar2:
                Log.v("prueba", "Esto es un ejemplo del boton 2");
                break;
        }
    }
}