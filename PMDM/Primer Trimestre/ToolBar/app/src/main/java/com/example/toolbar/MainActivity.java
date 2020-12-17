package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        personalizacionToolBar();
    }

    private void personalizacionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo titulo del proyecto");
        Glide.with(getApplicationContext()).load("https://blog.cambridge.es/wp-content/uploads/2017/09/ejemplo-aprendizaje.jpg").circleCrop().into(imagen);

    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        imagen = findViewById(R.id.imagen_glide);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_uno,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_uno:
                Toast.makeText(getApplicationContext(),"Pulsado",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}