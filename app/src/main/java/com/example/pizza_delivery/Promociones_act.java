package com.example.pizza_delivery;

import Models.Promociones;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Promociones_act extends AppCompatActivity {
    private Spinner spin1;
    private EditText et_promociones, et_envio;
    private TextView tv, tv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spin1 = (Spinner)findViewById(R.id.spinner);
        et_promociones = (EditText)findViewById(R.id.et_promocion);
        et_envio = (EditText)findViewById(R.id.et_envio);
        tv = (TextView)findViewById(R.id.tv);
        tv_total = (TextView)findViewById(R.id.tv_total);

        ArrayList<String> listaClientes = new ArrayList<String>();
        listaClientes.add("Ramiro");
        listaClientes.add("Rosa");
        listaClientes.add("Robert");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        spin1.setAdapter(adapter);
    }

    public void Calcular(View view){
        String cliente = spin1.getSelectedItem().toString();
        int numero = Integer.parseInt(et_envio.getText().toString());



        if(et_promociones.getText().toString().equals("Pizzas promo")){
            int total = 5990 + numero;
            tv.setText("Estimado " + cliente + " el final según promoción es:");
            tv_total.setText("$" + total);
        }
        if(et_promociones.getText().toString().equals("Marter pizzas ")){
            int total = 12990 + numero;
            tv.setText("Estimado " + cliente + " el final según promoción es:");
            tv_total.setText("$" + total);
        }
        if(et_promociones.getText().toString().equals("Pizzas max")){
            int total = 18500 + numero;
            tv.setText("Estimado " + cliente + " el final según promoción es:");
            tv_total.setText("$" + total);
        }
    }
}