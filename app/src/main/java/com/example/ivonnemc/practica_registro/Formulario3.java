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

public class Formulario3 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvDireccion;
    TextView tvTelefono;
    TextView tvFecha;
    Button btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario3);


        Bundle parametros = getIntent().getExtras();

        String nom = parametros.getString("nombre");
        String dir = parametros.getString("direccion");
        String tel = parametros.getString("telefono");
        String fech = parametros.getString("fecha");


        tvNombre = (TextView) findViewById(R.id.idtxtNom);
        tvDireccion = (TextView) findViewById(R.id.idtxtDirec);
        tvTelefono = (TextView) findViewById(R.id.idtxtTel);
        tvFecha = (TextView) findViewById(R.id.idtxtFech);
        btnsalir = (Button)findViewById(R.id.btnSalir);


        tvNombre.setText(nom);
        tvDireccion.setText(dir);
        tvTelefono.setText(tel);
        tvFecha.setText(fech);

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);

                finish();
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}