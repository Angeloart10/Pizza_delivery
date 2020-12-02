package com.example.pizza_delivery;

import Models.Cliente;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Firebase_act extends AppCompatActivity {

    private EditText etNombre, etDestino, etPromocion;
    private Button btn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etDestino = (EditText)findViewById(R.id.etDestino);
        etPromocion = (EditText)findViewById(R.id.etPromocion);
        btn = (Button)findViewById(R.id.btn);

        InicializarFirebase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etNombre.equals("")){
                    Cliente cliente = new Cliente();

                    cliente.setId(UUID.randomUUID().toString());
                    cliente.setNombre(etNombre.getText().toString());
                    cliente.setDestino(etDestino.getText().toString());
                    cliente.setPromocion(etPromocion.getText().toString());

                    databaseReference.child("Clientes").child(cliente.getId()).setValue(cliente);

                    Toast.makeText(getBaseContext(), "Se ha guardado!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "No se ha guardado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void InicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Listado(View view){
        Intent i = new Intent(this, ListadoClientes_act.class);
        startActivity(i);
    }


}