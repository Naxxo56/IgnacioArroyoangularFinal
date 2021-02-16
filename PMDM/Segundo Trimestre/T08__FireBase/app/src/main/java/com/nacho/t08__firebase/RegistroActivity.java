package com.nacho.t08__firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editNombre, editPass;
    private Button botonRegistro, botonVer, botonLogin;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        instancias();
        acciones();
    }
    private void acciones() {
        botonVer.setOnClickListener(this);
        botonLogin.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
    }

    private void instancias() {
        editNombre = findViewById(R.id.edit_usuario);
        editPass = findViewById(R.id.edit_contra);
        botonRegistro = findViewById(R.id.boton_registro);
        botonVer = findViewById(R.id.boton_ver);
        botonLogin = findViewById(R.id.boton_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_registro:

                firebaseAuth.createUserWithEmailAndPassword(editNombre.getText().toString(), editPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistroActivity.this, "El usuario se ha creado correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegistroActivity.this, "El usuario NO se ha creado correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.boton_ver:
                Log.v("usuarios", firebaseUser.getUid());
                break;

            case R.id.boton_login:
                firebaseAuth.signInWithEmailAndPassword(editNombre.getText().toString(), editPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent =new Intent(RegistroActivity.this, MainActivity.class);
                            intent.putExtra("uid",firebaseAuth.getCurrentUser().getUid());
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegistroActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}