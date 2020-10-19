package com.nacho.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editResumen, editOperaciones;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        /*if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            accionesLand();
        }
        */
    }

    private void acciones() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }

    public void accionesLand() {
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    private void instancias() {
        editOperaciones = findViewById(R.id.edit_operaciones);
        editResumen = findViewById(R.id.edit_resumen);
        btn1 = findViewById(R.id.boton_cal1);
        btn2 = findViewById(R.id.boton_cal2);
        btn3 = findViewById(R.id.boton_cal3);
        btn4 = findViewById(R.id.boton_cal4);

        btn5 = findViewById(R.id.boton_cal5);
        btn6 = findViewById(R.id.boton_cal6);
        btn7 = findViewById(R.id.boton_cal7);
        btn8 = findViewById(R.id.boton_cal8);
    }


    @Override
    public void onClick(View v) {
        //gestion de la pulsacion de todos los elementos que tengan onclick
        //donde view es el elemento que ha producido la pulsacion
        String operandos = editOperaciones.getText().toString();
        switch (v.getId()) {
            case R.id.boton_cal1:
                editOperaciones.setText(operandos + btn1.getText());
                break;
            case R.id.boton_cal2:
                editOperaciones.setText(operandos + btn2.getText());
                break;
            case R.id.boton_cal3:
                editOperaciones.setText(operandos + btn3.getText());
                break;
            case R.id.boton_cal4:
                editOperaciones.setText(operandos + btn4.getText());
                break;
            case R.id.boton_cal5:
                editOperaciones.setText(operandos + btn5.getText());
                break;
            case R.id.boton_cal6:
                editOperaciones.setText(operandos + btn6.getText());
                break;
            case R.id.boton_cal7:
                editOperaciones.setText(operandos + btn7.getText());
                break;
            case R.id.boton_cal8:
                editOperaciones.setText(operandos + btn8.getText());
                break;
        }
    }
}