package com.nacho.reservavuelos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.nacho.reservavuelos.adaptadores.AdaptadorRecycler;
import com.nacho.reservavuelos.adaptadores.AdaptadorSpinner;
import com.nacho.reservavuelos.dialogos.DialogoFecha;
import com.nacho.reservavuelos.dialogos.DialogoHora;
import com.nacho.reservavuelos.utils.Pais;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener, AdaptadorRecycler.OnPaisRecyclerListener {

    private Spinner spinnerPaises;
    private Spinner spinnerPaises2;
    private ArrayList<Pais> listaCiudades;
    private AdaptadorSpinner adaptadorSpinner;
    private CheckBox checkBox;
    private TextView fechaSalida, horaSalida, fechaLlegada, horaLlegada;
    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private Button botonAgregarViajes;
    private boolean flgFechaHora = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarViajes();
        rellenarRecycler();
        acciones();
    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        adaptadorRecycler.notifyDataSetChanged();
    }

    private void rellenarViajes() {
        spinnerPaises.setAdapter(adaptadorSpinner);
        spinnerPaises2.setAdapter(adaptadorSpinner);

        listaCiudades.add(new Pais("New York", R.drawable.nuevayork));
        listaCiudades.add(new Pais("San Francisco", R.drawable.sanfrancisco));
        listaCiudades.add(new Pais("Los Angeles", R.drawable.losangeles));
        listaCiudades.add(new Pais("Roma", R.drawable.roma));
        listaCiudades.add(new Pais("Florencia", R.drawable.florencia));
        listaCiudades.add(new Pais("Barcelona", R.drawable.barcelona));
        listaCiudades.add(new Pais("Madrid", R.drawable.madrid));

        adaptadorSpinner.notifyDataSetChanged();
    }

    private void instancias() {
        spinnerPaises = findViewById(R.id.spinnerVueloUno);
        spinnerPaises2 = findViewById(R.id.spinnerVueloDos);
        listaCiudades = new ArrayList();
        adaptadorSpinner = new AdaptadorSpinner(listaCiudades, getApplicationContext());
        checkBox = findViewById(R.id.check_ida);
        fechaSalida = findViewById(R.id.fecha_salida);
        horaSalida = findViewById(R.id.hora_salida);
        fechaLlegada = findViewById(R.id.fecha_llegada);
        horaLlegada = findViewById(R.id.hora_llegada);
        recyclerView = findViewById(R.id.recycler_main);
        adaptadorRecycler = new AdaptadorRecycler(this, listaCiudades);
        botonAgregarViajes = findViewById(R.id.boton_agregar_viaje);

    }

    private void acciones() {
        checkBox.setOnCheckedChangeListener(this);
        fechaSalida.setOnClickListener(this);
        horaSalida.setOnClickListener(this);
        fechaLlegada.setOnClickListener(this);
        horaLlegada.setOnClickListener(this);
        botonAgregarViajes.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_buscador:
                //AÑADIR FUNCION DE BUSCADOR (FILTRAR)
                break;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.check_ida:
                spinnerPaises2.setEnabled(!b);
                horaLlegada.setEnabled(!b);
                fechaLlegada.setEnabled(!b);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fecha_salida:
                this.flgFechaHora = true;
                DialogoFecha dialogoFechaSalida = new DialogoFecha();
                dialogoFechaSalida.show(getSupportFragmentManager(), "fecha");

                break;
            case R.id.hora_salida:
                this.flgFechaHora = true;
                DialogoHora dialogoHoraSalida = new DialogoHora();
                dialogoHoraSalida.show(getSupportFragmentManager(), "hora");

                break;
            case R.id.fecha_llegada:
                this.flgFechaHora = false;
                DialogoFecha dialogoFechaLlegada = new DialogoFecha();
                dialogoFechaLlegada.show(getSupportFragmentManager(), "fecha");

                break;
            case R.id.hora_llegada:
                this.flgFechaHora = false;
                DialogoHora dialogoHoraLlegada = new DialogoHora();
                dialogoHoraLlegada.show(getSupportFragmentManager(), "hora");

                break;

            case R.id.boton_agregar_viaje:
                Toast.makeText(MainActivity.this, "boton agregar viaje pulsado", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        if (this.flgFechaHora) {
            fechaSalida.setText(String.format("%d/%d/%d", i2, i1 + 1, i));
        } else {
            fechaLlegada.setText(String.format("%d/%d/%d", i2, i1 + 1, i));
        }


    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        if (this.flgFechaHora) {
            horaSalida.setText(String.format("%d:%d", i, i1));
        } else {
            horaLlegada.setText(String.format("%d:%d", i, i1));
        }
    }

    @Override
    public void onPaisSelected(Pais pais) {
        Toast.makeText(getApplicationContext(), pais.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaisLongSelected() {

    }
}