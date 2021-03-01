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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.adaptadores.AdaptadorEquipos;
import com.nacho.ignacioarroyofinalpmdm.utils.Equipo;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentEquipos extends Fragment {

    Liga liga;
    private RecyclerView recyclerEquipo;
    private AdaptadorEquipos adaptadorEquipos;
    private View view;

    public static FragmentEquipos newInstance(Liga liga) {

        Bundle args = new Bundle();
        args.putSerializable("liga", liga);
        FragmentEquipos fragment = new FragmentEquipos();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            liga = (Liga) getArguments().getSerializable("liga");
            adaptadorEquipos = new AdaptadorEquipos(context);
            rellenarLista();
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
    }

    private void instancias() {
        recyclerEquipo = view.findViewById(R.id.recycler_ligas);
        recyclerEquipo.setAdapter(adaptadorEquipos);
        recyclerEquipo.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void rellenarLista() {

        String url = String.format("https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=%s", liga.getId());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
                Log.v("prueba", "realizar peticion");
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

            Log.v("prueba", "procesar peticion");
            JSONArray arrayEquipos = response.getJSONArray("teams");
            for (int i = 0; i < arrayEquipos.length(); i++) {
                JSONObject equipo = arrayEquipos.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                String id = equipo.getString("idTeam");
                String escudo = equipo.getString("strTeamBadge");
                String banner = equipo.getString("strTeamBanner");
                String fb = equipo.getString("strFacebook");
                String tw = equipo.getString("strTwitter");
                String descripcion = equipo.getString("strDescriptionEN");
                String web = equipo.getString("strWebsite");
                String insta = equipo.getString("strInstagram");
                adaptadorEquipos.rellenarLista(new Equipo(banner, nombre, descripcion, escudo, id, tw, fb, web, insta));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
