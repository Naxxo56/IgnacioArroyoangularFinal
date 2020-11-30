package com.borja.t3_elementos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHelados, btnBebidas,btnEnsaladas, btnCafe, btnHamburguesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_normal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent i = null;

        switch (item.getItemId()) {
            case R.id.menu_opcion_hamburguesa:
                i = new Intent(getApplicationContext(), RecyclerHamburguesasActivity.class);
                break;
            case R.id.menu_opcion_helado:
                i = new Intent(getApplicationContext(), RecyclerHeladosActivity.class);

                break;
            case R.id.menu_opcion_cafe:
                i = new Intent(getApplicationContext(), RecyclerCafeActivity.class);

                break;
            case R.id.menu_opcion_ensalada:
                i = new Intent(getApplicationContext(), RecyclerEnsaladasActivity.class);

                break;
            case R.id.menu_opcion_bebida:
                i = new Intent(getApplicationContext(), RecyclerBebidasActivity.class);
                break;
        }
        startActivity(i);
        return true;
    }

    private void acciones() {
        btnHamburguesas.setOnClickListener(this);
        btnHelados.setOnClickListener(this);
        btnBebidas.setOnClickListener(this);
        btnEnsaladas.setOnClickListener(this);
        btnCafe.setOnClickListener(this);
    }

    private void instancias() {
        btnHamburguesas = findViewById(R.id.boton_recycler_hamburguesa);
        btnHelados = findViewById(R.id.boton_act_helados);
        btnBebidas = findViewById(R.id.boton_act_bebidas);
        btnEnsaladas = findViewById(R.id.boton_act_Ensaladas);
        btnCafe = findViewById(R.id.boton_act_cafe);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.boton_act_helados:
                intent = new Intent(getApplicationContext(), RecyclerHeladosActivity.class);
                break;
            case R.id.boton_act_bebidas:
                intent = new Intent(getApplicationContext(), RecyclerBebidasActivity.class);
                break;
            case R.id.boton_act_Ensaladas:
                intent = new Intent(getApplicationContext(), RecyclerEnsaladasActivity.class);
                break;
            case R.id.boton_act_cafe:
                intent = new Intent(getApplicationContext(), RecyclerCafeActivity.class);
                break;
            case R.id.boton_recycler_hamburguesa:
                intent = new Intent(getApplicationContext(), RecyclerHamburguesasActivity.class);
                break;
        }
        startActivity(intent);

    }
}