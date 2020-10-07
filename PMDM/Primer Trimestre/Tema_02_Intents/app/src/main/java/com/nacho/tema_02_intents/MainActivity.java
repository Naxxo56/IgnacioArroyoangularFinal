package com.nacho.tema_02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nacho.tema_02_intents.utils.Persona;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonArranque, botonDatos;

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

    public void instancias() {
        botonArranque = findViewById(R.id.boton_arrancar_pantalla);
        botonDatos = findViewById(R.id.boton_arrancar_pantalla_dato);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.boton_arrancar_pantalla:
                intent= new Intent(getApplicationContext(),SegundaActivity.class);
                break;
            case R.id.boton_arrancar_pantalla_dato:
                intent= new Intent(getApplicationContext(),SegundaActivity.class);
                /*
                intent.putExtra("nombre","Nacho");
                intent.putExtra("apellido","Arroyo");
                intent.putExtra("edad",20);
                intent.putExtra("experiencia",true);
                 */
                intent.putExtra("persona", new Persona("Nacho ","Arroyo ",20 , true ));
                break;
        }
        startActivity(intent);
    }
}