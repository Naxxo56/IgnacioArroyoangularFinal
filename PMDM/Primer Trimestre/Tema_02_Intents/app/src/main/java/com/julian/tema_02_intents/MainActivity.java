package com.julian.tema_02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonArranque, botonDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonDatos.setOnClickListener(this);
        botonArranque.setOnClickListener(this);
    }

    public  void instancias(){
        botonArranque = findViewById(R.id.boton_arrancar_pantalla);
        botonDatos = findViewById(R.id.boton_arrancar_pantalla_dato);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton_arrancar_pantalla:
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                startActivity(intent);
                break;
            case  R.id.boton_arrancar_pantalla_dato:

                break;
        }
    }
}