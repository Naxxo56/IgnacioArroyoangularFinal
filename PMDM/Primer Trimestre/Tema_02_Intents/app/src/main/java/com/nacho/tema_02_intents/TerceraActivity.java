package com.nacho.tema_02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TerceraActivity extends AppCompatActivity {
    Button botonRespuesta;
    EditText editInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        botonRespuesta = findViewById(R.id.boton_responder);
        editInicial = findViewById(R.id.edit_prueba);
        botonRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent();
                intent.putExtra("dato1",1);
                intent.putExtra("dato2",false);
                setResult(0,intent);
                finish();

                 */
                String texto = editInicial.getText().toString();
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
            }
        });


    }
}