package com.nacho.ignacioarroyofinalpmdm.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.adaptadores.AdaptadorLiga;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentPrincipal extends Fragment {

    private RecyclerView recyclerLigas;
    private AdaptadorLiga adaptadorLiga;
    private View view;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adaptadorLiga = new AdaptadorLiga(getContext());
        realizarPeticion();
    }

    private void realizarPeticion() {

        String url = "https://www.thesportsdb.com/api/v1/json/1/all_leagues.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("prueba", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray arrayLigas = response.getJSONArray("leagues");
            for (int i = 0; i < arrayLigas.length(); i++) {
                JSONObject liga = (JSONObject) arrayLigas.get(i);
                String nombreLiga = liga.getString("strLeague");
                String idLiga = liga.getString("idLeague");
                adaptadorLiga.rellenarLista(new Liga(nombreLiga, idLiga));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_recycler_general, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        iniciarRecycler();
    }

    private void iniciarRecycler() {
        recyclerLigas.setAdapter(adaptadorLiga);
        recyclerLigas.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void instancias() {
        recyclerLigas = getView().findViewById(R.id.recycler_ligas);
    }

}
