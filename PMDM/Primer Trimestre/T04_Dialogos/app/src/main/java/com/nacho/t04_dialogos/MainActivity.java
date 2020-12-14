package com.nacho.t04_dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.nacho.t04_dialogos.dialogos.DialogoConfirmacion;
import com.nacho.t04_dialogos.dialogos.DialogoFecha;
import com.nacho.t04_dialogos.dialogos.DialogoHora;
import com.nacho.t04_dialogos.dialogos.DialogoInfoApp;
import com.nacho.t04_dialogos.dialogos.DialogoLista;
import com.nacho.t04_dialogos.dialogos.DialogoMultiple;
import com.nacho.t04_dialogos.dialogos.DialogoPersonalizado;
import com.nacho.t04_dialogos.dialogos.DialogoSingle;
import com.nacho.t04_dialogos.utils.Equipo;

public class MainActivity extends AppCompatActivity implements DialogoConfirmacion.OnDialogoConfirmacion,
        DialogoLista.OnDialogoLista, DialogoSingle.OnDialogoSingle, DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    TextView textView;
    private String user = "Nacho",pass = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        textView = findViewById(R.id.contestacion_dialogo);
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
                dialogoConfirmacion.show(getSupportFragmentManager(), "");
                break;
            case R.id.menu_dialogo_lista:
                DialogoLista dialogoLista = new DialogoLista();
                dialogoLista.show(getSupportFragmentManager(), "Lista");
                break;
            case R.id.menu_dialogo_single:
                DialogoSingle dialogoSingle = new DialogoSingle();
                dialogoSingle.show(getSupportFragmentManager(), "single");
                break;
            case R.id.menu_dialogo_multiple:

                DialogoMultiple dialogoMultiple = new DialogoMultiple();
                dialogoMultiple.show(getSupportFragmentManager(), "multiple");

                break;
            case R.id.menu_dialogo_fecha:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), "fecha");
                break;
            case R.id.menu_dialogo_hora:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(),"hora");
                break;
            case R.id.menu_dialogo_personalizado:
                DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
                dialogoPersonalizado.show(getSupportFragmentManager(),"personalizado");
                break;
        }
        return true;
    }

    @Override
    public void onDialogoConfirmacionSelected(String confirmacion) {
        textView.setText(confirmacion);
    }

    @Override
    public void onDialogoListaSelected(String opcion) {
        textView.setText(opcion);
    }

    @Override
    public void onDialogoSingleSelected(String opcion) {
        textView.setText(opcion);
    }

    @Override
    public void onDialogoEquipoSingleListener(Equipo equipo) {
        textView.setText(equipo.getNombre());
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        textView.setText(String.format("%d/%d/%d", i2, i1 + 1, i));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        textView.setText(String.format("%d:%d", i, i1));
    }
}