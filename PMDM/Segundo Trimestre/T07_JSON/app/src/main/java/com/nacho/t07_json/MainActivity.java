package com.nacho.t07_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nacho.t07_json.utils.Persona;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPersonas= new ArrayList();
        realizarPeticion();
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray arrayResultados = response.getJSONArray("results");
            //Log.v("prueba", arrayResultados.toString());
            for (int i = 0; i < arrayResultados.length(); i++) {
                JSONObject persona = arrayResultados.getJSONObject(i);

                String email = persona.getString("email");
                String phone = persona.getString("cell");

                JSONObject nombre = persona.getJSONObject("name");
                String titulo = nombre.getString("title");
                String nombrePersona = nombre.getString("first");
                String apellidoPersona = nombre.getString("last");

                JSONObject imagen = persona.getJSONObject("picture");
                String imagenPersona = imagen.getString("large");

                Persona personaAgregar = new Persona(nombrePersona,apellidoPersona,imagenPersona,email,phone);
                listaPersonas.add(personaAgregar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void realizarPeticion() {

        String url = "https://randomuser.me/api/?results=100";

        //PETICION VOLLEY
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
                Toast.makeText(MainActivity.this, "Personas en la lista: " + listaPersonas.size() + " añadidas correctamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("prueba", error.toString());
            }
        });


        //PILA DE VOLLEY
        //Si solo es una se hace directo ----> Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);
        //Si son varias --->
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        request.add(jsonObjectRequest);
    }
}