package com.nacho.tema_02_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nacho.tema_02_intents.utils.Persona;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonArranque, botonDatos, botonResultado;

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
        botonResultado.setOnClickListener(this);
    }

    public void instancias() {
        botonArranque = findViewById(R.id.boton_arrancar_pantalla);
        botonDatos = findViewById(R.id.boton_arrancar_pantalla_dato);
        botonResultado = findViewById(R.id.boton_arrancar_pantalla_resultado);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {
            Bundle bundle = data.getExtras();
            int numero = bundle.getInt("dato1");
            boolean cierto = bundle.getBoolean("dato2");
            Log.v("Arranque", "Arranque y resultado 0"
                    + String.valueOf (numero) +  String.valueOf (cierto));
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.boton_arrancar_pantalla:
                intent = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivity(intent);
                break;
            case R.id.boton_arrancar_pantalla_dato:
                intent = new Intent(getApplicationContext(), SegundaActivity.class);
                /*
                intent.putExtra("nombre","Nacho");
                intent.putExtra("apellido","Arroyo");
                intent.putExtra("edad",20);
                intent.putExtra("experiencia",true);
                 */
                intent.putExtra("persona", new Persona("Nacho ", "Arroyo ", 20, true));
                startActivity(intent);
                break;
            case R.id.boton_arrancar_pantalla_resultado:
                intent = new Intent(getApplicationContext(), TerceraActivity.class);
                startActivityForResult(intent, 0);
                break;
        }


    }
}