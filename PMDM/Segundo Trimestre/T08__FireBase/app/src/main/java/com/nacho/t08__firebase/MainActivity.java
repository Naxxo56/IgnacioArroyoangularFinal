package com.nacho.t08__firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private TextView textoUID;
    private Button btnAddMain;
    private FirebaseDatabase firebaseDatabase;
    private String recuperado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        recuperarDato();
        acciones();
    }

    private void recuperarDato() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            recuperado = bundle.get("uid").toString();
            textoUID.setText(bundle.get("uid").toString());
        }
    }

    private void acciones() {
        btnAddMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase.getReference("usuarios");
                nodoReferencia.setValue("hola");
            }
        });
    }
    private void instancias() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://iniciofb-9cd1f-default-rtdb.europe-west1.firebasedatabase.app/");
        btnAddMain = findViewById(R.id.button_nodo_princial);
        textoUID = findViewById(R.id.cabecera_uid);

    }
}