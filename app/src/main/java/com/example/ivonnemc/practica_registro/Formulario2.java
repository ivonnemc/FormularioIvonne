package com.example.ivonnemc.practica_registro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ivonne MC on 30/03/2017.
 */

public class Formulario2 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvDireccion;
    TextView tvTelefono;
    TextView tvFecha;
    Button btnEditar;
    Button btnEnvio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario2);

        Bundle parametros = getIntent().getExtras();


        String nombre = parametros.getString("nombre");
        String direccion = parametros.getString("direccion");
        String telefono = parametros.getString("telefono");
        String fecha = parametros.getString("fecha");


        tvNombre = (TextView) findViewById(R.id.idtxtNom);
        tvDireccion = (TextView) findViewById(R.id.idtxtDirec);
        tvTelefono = (TextView) findViewById(R.id.idtxtTel);
        tvFecha = (TextView) findViewById(R.id.txtFecha);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEnvio2 = (Button) findViewById(R.id.btnEnvio2);

        tvNombre.setText(nombre);
        tvDireccion.setText(direccion);
        tvTelefono.setText(telefono);
        tvFecha.setText(fecha);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnEnvio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = tvNombre.getText().toString();
                String dir = tvDireccion.getText().toString();
                String tel = tvTelefono.getText().toString();
                String fech = tvFecha.getText().toString();
                Intent i = new Intent(Formulario2.this, Formulario3.class);
                i.putExtra("nombre", nom);
                i.putExtra("direccion", dir);
                i.putExtra("telefono", tel);
                i.putExtra("fecha", fech);
                startActivity(i);
            }
        });

    }

    }
