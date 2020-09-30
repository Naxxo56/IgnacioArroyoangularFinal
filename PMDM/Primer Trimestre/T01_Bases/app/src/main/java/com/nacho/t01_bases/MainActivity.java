package com.nacho.t01_bases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botonInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonInicial = findViewById(R.id.boton_inicial);
        botonInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.saludo,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Ejemplo",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "Ejemplo de Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
}