package com.nacho.t06_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nacho.t06_fragments.fragments.FragmentDos;
import com.nacho.t06_fragments.fragments.FragmentFuncional;
import com.nacho.t06_fragments.fragments.FragmentTres;
import com.nacho.t06_fragments.fragments.FragmentUno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentFuncional.OnFragmentFuncionalListener {

    private Button botonIrF1, botonIrF2, botonIrF3;
    FragmentManager fm;
    FragmentTransaction ft;
    int cuentaFg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancias();
        //acciones();

        /*
        //representa el elemento que permite gestionar todos los fragments (como una pila)
        FragmentManager fm = getSupportFragmentManager();
        //elemento que permite manejar los fragment, entrando , saliendo , quitando.
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, new FragmentUno(), "f1");
        ft.commit();

        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();
        ft2.replace(R.id.sitio_fragments, new FragmentDos(), "f2");
        ft2.commit();
         */
    }
    /*
    private void acciones() {
        botonIrF1.setOnClickListener(this);
        botonIrF2.setOnClickListener(this);
        botonIrF3.setOnClickListener(this);
    }

    private void instancias() {
        botonIrF1 = findViewById(R.id.boton_ir_F1);
        botonIrF2 = findViewById(R.id.boton_ir_F2);
        botonIrF3 = findViewById(R.id.boton_ir_F3);
    }


    @Override
    public void onClick(View view) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        FragmentManager.BackStackEntry backStackEntry = null;
        if (cuentaFg != 0) {
            backStackEntry = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1);
        }
        switch (view.getId()) {
            case R.id.boton_ir_F1:
                ft.add(R.id.sitio_fragments, new FragmentUno(), "f1");
                if (cuentaFg > 0) {
                    Log.v("prueba_fg", String.valueOf(backStackEntry.getName()));
                    if (!backStackEntry.getName().equals("f1")) {
                        ft.addToBackStack("f1");
                    }
                } else {
                    ft.addToBackStack("f1");
                }
                cuentaFg++;
                break;
            case R.id.boton_ir_F2:
                ft.add(R.id.sitio_fragments, new FragmentDos(), "f2");
                if (cuentaFg > 0) {
                    Log.v("prueba_fg", String.valueOf(backStackEntry.getName()));
                    if (!backStackEntry.getName().equals("f2")) {
                        ft.addToBackStack("f2");
                    }
                } else {
                    ft.addToBackStack("f2");
                }
                cuentaFg++;
                break;
            case R.id.boton_ir_F3:
                int cuentaPila = fm.getBackStackEntryCount();
                //ft.replace(R.id.sitio_fragments, new FragmentTres(), "f3");
                FragmentManager.BackStackEntry backStackEntry2 = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1);
                Log.v("prueba_fg", "Etiqueta estado " + String.valueOf(backStackEntry2.getName()));
                Log.v("prueba_fg", "Numero estados " + String.valueOf(cuentaPila));
                Log.v("prueba_fg", "Numero fragments " + String.valueOf(fm.getFragments().size()));

                ArrayList<Fragment> listaFragments = (ArrayList<Fragment>) fm.getFragments();
                for (Fragment fragment : listaFragments) {
                    Log.v("prueba_fg", "Fragment apilado " + String.valueOf(fragment));
                }
                Fragment fragmentEncontrado = getSupportFragmentManager().findFragmentByTag(backStackEntry2.getName());
                Log.v("prueba_fg", "Fragment encontado " + String.valueOf(fragmentEncontrado));

                break;
        }
        ft.commit();
    }

     */

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*
        Log.v("prueba_fg", "pulsado onBack");
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Te quedan " + getSupportFragmentManager().getBackStackEntryCount() + " intentos", Toast.LENGTH_SHORT).show();
        }
         */
    }

    @Override
    public void comunicarPulsacion(String tag) {
        //Toast.makeText(getApplicationContext(),"Pulsado desde "+ tag,Toast.LENGTH_SHORT).show();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        Fragment fEncontrado = fm.findFragmentByTag(tag);
        switch (tag) {
            case "f1":
                if (fEncontrado != null) {
                    Log.v("fragmentEj", fEncontrado.toString());
                    ft.replace(R.id.sitio_fragments, fEncontrado);
                } else {
                    Log.v("fragmentEj", "No se encuentra ningun fragment");
                    ft.add(R.id.sitio_fragments,new FragmentUno(),tag);
                }
                break;
            case "f2":
                if (fEncontrado != null) {
                    Log.v("fragmentEj", fEncontrado.toString());
                    ft.replace(R.id.sitio_fragments, fEncontrado);
                } else {
                    Log.v("fragmentEj", "No se encuentra ningun fragment");
                    ft.add(R.id.sitio_fragments,new FragmentDos(),tag);
                }
                break;
        }
        ft.addToBackStack(tag);
        ft.commit();
        Log.v("cuenta_fg", String.valueOf(fm.getFragments().size()));

    }

    @Override
    public void buscarFragment(String tag) {
        //Toast.makeText(getApplicationContext(), "Pulsado desde buscar " + tag, Toast.LENGTH_SHORT).show();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        Fragment fEncontrado = fm.findFragmentByTag(tag);
        if (fEncontrado != null) {
            Log.v("fragmentEj", fEncontrado.toString());
            ft.replace(R.id.sitio_fragments, fEncontrado);
            ft.commit();
        } else {
            Log.v("fragmentEj", "No se encuentra ningun fragment");
        }
    }
}