package com.nacho.tema_02_intents;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nacho.tema_02_intents.utils.Persona;

public class SegundaActivity extends AppCompatActivity {
    private TextView texto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        instancias();
        if(getIntent().getExtras()!=null){
            recuperarDatos();
        }
    }

    private void instancias() {
        texto = findViewById(R.id.texto_pantalla_dos);
    }

    private void recuperarDatos() {
        //el bundle es como la caja con los datos
        Bundle bundle = getIntent().getExtras();
        /*
        String nombreRecuperado = bundle.getString("nombre");
        String apellidoRecuperado = bundle.getString("apellido");
        int edadRecuperada = bundle.getInt("edad");
        Boolean experienciaRecuperada = bundle.getBoolean("experiencia");
         */
        Persona persona = (Persona) bundle.getSerializable("persona");
        texto.setText(persona.getNombre()+""+persona.getApellido()+""+persona.getEdad()+""+persona.isExperiencia());
    }

}
