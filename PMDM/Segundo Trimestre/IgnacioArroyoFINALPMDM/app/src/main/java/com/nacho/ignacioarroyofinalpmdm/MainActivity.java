package com.nacho.ignacioarroyofinalpmdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.nacho.ignacioarroyofinalpmdm.adaptadores.AdaptadorEquipos;
import com.nacho.ignacioarroyofinalpmdm.adaptadores.AdaptadorLiga;
import com.nacho.ignacioarroyofinalpmdm.fragments.FragmentDetalle;
import com.nacho.ignacioarroyofinalpmdm.fragments.FragmentEquipos;
import com.nacho.ignacioarroyofinalpmdm.fragments.FragmentPrincipal;
import com.nacho.ignacioarroyofinalpmdm.utils.Equipo;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorLiga.OnLigaListener, AdaptadorEquipos.OnEquipoListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigation;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private FrameLayout sitioFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarToolBar();
        toolbar.setTitle("Todas las ligas");
        acciones();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, new FragmentPrincipal(), "fp");
        ft.addToBackStack("bs");
        ft.commit();
    }

    private void acciones() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_punto_inicial:
                        //Toast.makeText(MainActivity.this, "menu punto", Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Todas las ligas");
                        fm = getSupportFragmentManager();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.sitio_fragments, new FragmentPrincipal(), "fp");
                        ft.addToBackStack("bs");
                        ft.commit();
                        break;
                    case R.id.menu_equipo_fav:
                        Toast.makeText(MainActivity.this, "menu fav", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_salir:
                        //Toast.makeText(MainActivity.this, "menu salir", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    private void configurarToolBar() {
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        sitioFragment = findViewById(R.id.sitio_fragments);
        drawerLayout = findViewById(R.id.drawer_main_layout);
        navigation = findViewById(R.id.menu_navigation);
    }

    @Override
    public void onLigaSelected(Liga liga) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, FragmentEquipos.newInstance(liga), "fl");
        toolbar.setTitle(liga.getNombreLiga());
        ft.addToBackStack("bs");
        ft.commit();
        //Toast.makeText(this, liga.getNombreLiga(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEquipoSelected(Equipo equipo) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, FragmentDetalle.newInstance(equipo), "fe");
        toolbar.setTitle(equipo.getNombre());
        ft.addToBackStack("bs");
        ft.commit();
        //Toast.makeText(this, equipo.getNombre(), Toast.LENGTH_SHORT).show();
    }
}