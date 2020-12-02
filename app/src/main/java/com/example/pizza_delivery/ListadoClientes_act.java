package com.example.pizza_delivery;

import Models.Cliente;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListadoClientes_act extends AppCompatActivity {

    private ListView list;

    private ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Cliente clientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);

        InicializarFirebase();

        list = (ListView)findViewById(R.id.lv);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren()){
                    Cliente c = objSnapshot.getValue(Cliente.class);
                    listClientes.add(c);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listClientes);
                    list.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clientesSelected = (Cliente) parent.getItemAtPosition(position);
            }
        });
    }

    public void Eliminar(View view){
        Cliente c = new Cliente();
        c.setId(clientesSelected.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();

        Toast.makeText(this, "Has eliminado un cliente", Toast.LENGTH_LONG).show();
    }

    public void InicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}