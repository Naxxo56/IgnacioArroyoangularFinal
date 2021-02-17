package com.nacho.t08__firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nacho.t08__firebase.utils.Equipo;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private TextView textoUID;
    private Button btnAddMain, btnObjeto, btnGetObjeto, btnGetDato;
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
                nodoReferencia.setValue(recuperado);
            }
        });

        btnObjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Equipo equipo = new Equipo("Leganes", "Liga Española");
                DatabaseReference nodoReferencia = firebaseDatabase.getReference("usuarios").child(recuperado).child("favoritos").child(equipo.getNombre());
                nodoReferencia.setValue(equipo);
            }
        });

        btnGetObjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase.getReference("usuarios").child(recuperado).child("favoritos");
                nodoReferencia.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        DataSnapshot dataSnapshot = task.getResult();
                        //dataSnapshot.getValue(Equipo.class);
                        Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                        while (iterator.hasNext()){
                            Equipo equipo = iterator.next().getValue(Equipo.class);
                            Log.v("iterador",equipo.getLiga());
                        }
                    }
                });
            }
        });

        btnGetDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase.getReference("usuarios").child(recuperado).child("favoritos").child("Leganes").child("nombre");
                nodoReferencia.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        Equipo equipo = task.getResult().getValue(Equipo.class);
                        Log.v("recuperado", task.getResult().getValue().toString());
                    }
                });
            }
        });
    }

    private void instancias() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://iniciofb-9cd1f-default-rtdb.europe-west1.firebasedatabase.app/");
        btnAddMain = findViewById(R.id.button_nodo_princial);
        textoUID = findViewById(R.id.cabecera_uid);
        btnObjeto = findViewById(R.id.button_nodo_secundario);
        btnGetObjeto = findViewById(R.id.button_get_objeto);
        btnGetDato = findViewById(R.id.button_get_dato);
    }
}