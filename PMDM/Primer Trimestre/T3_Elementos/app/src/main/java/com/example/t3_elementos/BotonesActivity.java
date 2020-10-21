package com.example.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BotonesActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Button botonNormal, botonValores;
    private ImageButton botonImagen;
    private ToggleButton toggleButton;
    private RadioButton radioSolo, radio1, radio2, radio3;
    private RadioGroup grupoRadios;
    private CheckBox checkBox;
    private SeekBar seekBar;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);
        instancias();
        personalizarBoton();
        acciones();
    }

    private void personalizarBoton() {
        botonValores.setEnabled(toggleButton.isChecked());
    }

    private void acciones() {
        botonValores.setOnClickListener(this);
        botonImagen.setOnClickListener(this);
        botonNormal.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
        toggleButton.setOnCheckedChangeListener(this);
        grupoRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*
                Toast.makeText(getApplicationContext(), String.valueOf(checkedId), Toast.LENGTH_SHORT).show();
                 */
                switch (checkedId) {
                    case R.id.radio_1:
                        Toast.makeText(getApplicationContext(), "Pulsado R1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_2:
                        Toast.makeText(getApplicationContext(), "Pulsado R2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_3:
                        Toast.makeText(getApplicationContext(), "Pulsado R3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void instancias() {
        botonNormal = findViewById(R.id.boton_Normal);
        botonImagen = findViewById(R.id.boton_imagen);
        botonValores = findViewById(R.id.boton_valores);
        toggleButton = findViewById(R.id.toggle_fondo);
        radioSolo = findViewById(R.id.radio);
        radio1 = findViewById(R.id.radio_1);
        radio2 = findViewById(R.id.radio_2);
        radio3 = findViewById(R.id.radio_3);
        grupoRadios = findViewById(R.id.grupo_radios);
        checkBox = findViewById(R.id.check);
        seekBar = findViewById(R.id.seekbar);
        ratingBar = findViewById(R.id.rating_bar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_Normal:
                break;
            case R.id.boton_imagen:
                break;
            case R.id.boton_valores:
                Toast.makeText(getApplicationContext(), String.valueOf(toggleButton.isChecked()), Toast.LENGTH_SHORT).show();

                radioSolo.setChecked(!radioSolo.isChecked());

                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggle_fondo:
                botonValores.setEnabled(isChecked);
                break;
            case R.id.check:
                botonValores.setEnabled(!isChecked);
                break;
        }
    }
}