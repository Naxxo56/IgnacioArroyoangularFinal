package com.nacho.t04_dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nacho.t04_dialogos.dialogos.DialogoConfirmacion;
import com.nacho.t04_dialogos.dialogos.DialogoInfoApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_informacion:
                DialogoInfoApp dialogoInfoApp = new DialogoInfoApp();
                dialogoInfoApp.show(getSupportFragmentManager(), "TAG1");
                break;
            case R.id.menu_dialogo_info:
                DialogoInfoApp dialogoInfoApp2 = new DialogoInfoApp();
                dialogoInfoApp2.show(getSupportFragmentManager(), "TAG1");
                break;
            case R.id.menu_dialogo_confimacion:
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(),"");
                break;
            case R.id.menu_dialogo_lista:
                break;
        }
        return true;
    }
}