package com.example.practicadialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.practicadialogos.dialogos.DialogoDos;
import com.example.practicadialogos.dialogos.DialogoUno;

public class MainActivity extends AppCompatActivity implements DialogoUno.OnDialogoConfirmacion,DialogoDos.OnDialogoConfirmacion{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // pone un menú en la ActionBar
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_dialogos:
                DialogoUno dialogoUno = new DialogoUno();
                dialogoUno.show(getSupportFragmentManager(), "");
                break;
        }
        return true;
    }

    @Override
    public void onDialogoConfirmacionSelected(String confirmacion) {
        if (confirmacion=="Si"){
            DialogoDos dialogoDos = new DialogoDos();
            dialogoDos.show(getSupportFragmentManager(), "");
        }
    }

    @Override
    public void onDialogoConfirmacionSelectedDos(String confirmacion) {

    }
}