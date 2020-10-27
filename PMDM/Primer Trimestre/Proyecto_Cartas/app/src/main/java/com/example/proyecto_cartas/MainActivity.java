package com.example.proyecto_cartas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonIniciar;
    private CheckBox checkPracticar;
    private TextView record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonIniciar.setOnClickListener(this);

    }

    private void instancias() {
        botonIniciar=findViewById(R.id.botonJugar);
        checkPracticar=findViewById(R.id.checkPracticar);
        record = findViewById(R.id.texto_record);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),JuegoActivity.class);
        int codigo;
        if(checkPracticar.isChecked()){
            codigo=0;
        }else{
            codigo=1;
        }
        startActivityForResult(intent,codigo);
    }
}