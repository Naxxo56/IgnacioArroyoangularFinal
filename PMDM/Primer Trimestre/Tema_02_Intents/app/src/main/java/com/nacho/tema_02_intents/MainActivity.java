package com.nacho.tema_02_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nacho.tema_02_intents.utils.Persona;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonArranque, botonDatos, botonResultado;
    EditText editNombre, editApellido, editTelefono;

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
        editApellido = findViewById(R.id.edit_apellido);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {
            Bundle bundle = data.getExtras();
            String dato = bundle.getString("dato_respuesta");
            Toast.makeText(getApplicationContext(),dato,Toast.LENGTH_SHORT).show();
            /*

            boolean cierto = bundle.getBoolean("dato2");
            Log.v("Arranque", "Arranque y resultado 0"
                    + String.valueOf(numero) + String.valueOf(cierto));

             */
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
                String nombre = editNombre.getText().toString();
                String apellido = editApellido.getText().toString();
                int telefono;
                if(!editTelefono.getText().toString().equals("")){
                     telefono = Integer.parseInt(editTelefono.getText().toString());
                }else{
                    telefono=0;
                }
                if(!nombre.isEmpty() && !apellido.isEmpty()){
                    intent.putExtra("persona", new Persona(nombre, apellido, telefono));
                    startActivity(intent);
                }

                break;
            case R.id.boton_arrancar_pantalla_resultado:
                intent = new Intent(getApplicationContext(), TerceraActivity.class);
                startActivityForResult(intent, 0);
                break;
        }
    }
}