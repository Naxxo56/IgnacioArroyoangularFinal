package com.nacho.ignacioarroyofinalpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroLogin extends AppCompatActivity implements View.OnClickListener {

    private Button botonLogin, botonRegistro;
    private EditText editUsuario, editPass;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_login);
        instancias();
        acciones();
    }

    private void acciones() {
        botonLogin.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
    }

    private void instancias() {
        editUsuario = findViewById(R.id.edit_usuario);
        editPass = findViewById(R.id.edit_contra);
        botonLogin = findViewById(R.id.boton_login);
        botonRegistro = findViewById(R.id.boton_registro);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_registro:
                firebaseAuth.createUserWithEmailAndPassword(editUsuario.getText().toString(), editPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistroLogin.this, "El usuario se ha creado correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegistroLogin.this, "El usuario NO se ha creado correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.boton_login:
                firebaseAuth.signInWithEmailAndPassword(editUsuario.getText().toString(), editPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegistroLogin.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}