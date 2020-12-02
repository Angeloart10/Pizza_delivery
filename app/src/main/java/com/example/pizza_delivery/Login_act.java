package com.example.pizza_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_act extends AppCompatActivity {

    private EditText edNombre, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);

        edNombre = (EditText)findViewById(R.id.et_user);
        edPassword = (EditText)findViewById(R.id.et_pass);
    }

    public void IniciarSesion(View view){

        String nombre = edNombre.getText().toString();
        String password = edPassword.getText().toString();

        if((edNombre.getText().toString().equals("ANDROID") || edNombre.getText().toString().equals("Android")) && edPassword.getText().toString().equals("123")){
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}