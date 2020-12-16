package com.example.practicadialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.practicadialogos.dialogos.DialogoCinco;
import com.example.practicadialogos.dialogos.DialogoCuatro;
import com.example.practicadialogos.dialogos.DialogoDos;
import com.example.practicadialogos.dialogos.DialogoTres;
import com.example.practicadialogos.dialogos.DialogoUno;

public class MainActivity extends AppCompatActivity implements DialogoUno.OnDialogoConfirmacion, DialogoDos.OnDialogoConfirmacion, DialogoTres.OnDialogoConfirmacion, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    String nombre = "";
    String fecha = "";
    String hora = "";

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
                dialogoUno.show(getSupportFragmentManager(), null);
                break;
        }
        return true;
    }

    @Override
    public void onDialogoConfirmacionSelected(String confirmacion) {
        if (confirmacion.equals("Si")) {
            DialogoDos dialogoDos = new DialogoDos();
            dialogoDos.show(getSupportFragmentManager(), "");
        }
    }

    @Override
    public void onDialogoConfirmacionSelectedDos(String nombre_comunicado) {
        //importante esto
        DialogoTres dialogoTres = DialogoTres.newInstance(nombre_comunicado);
        dialogoTres.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onDialogoConfirmacionSelectedTres(String confirmacion) {
        if (confirmacion.equals("Si")) {
            DialogoCuatro dialogoCuatro = new DialogoCuatro();
            dialogoCuatro.show(getSupportFragmentManager(), "");
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        this.fecha = String.format("%d/%d/%d", i2, i1 + 1, i);
        DialogoCinco dialogoCinco = new DialogoCinco();
        dialogoCinco.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        this.hora = String.format("%d:%d", i, i1);
        if (!nombre.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("fecha", fecha);
            intent.putExtra("hora", hora);
            startActivity(intent);
        }
    }
}
