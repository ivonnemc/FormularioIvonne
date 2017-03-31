package com.example.ivonnemc.practica_registro;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText idNombre, idDireccion, idTelefono,campofecha;
    private Button btnEnvio, btnFecha;
    private int año, mes, dia;
    private static final int CUADRO_DIALOGO=0;
    private static DatePickerDialog.OnDateSetListener escuchaSelectorFecha;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idNombre = (EditText) findViewById(R.id.idNombre);
        idDireccion = (EditText) findViewById(R.id.idDireccion);
        idTelefono = (EditText) findViewById(R.id.idTelefono);
        campofecha = (EditText) findViewById(R.id.idFecha);
        btnEnvio = (Button) findViewById(R.id.btnEnvio2);
        btnFecha = (Button) findViewById(R.id.btnFecha);

        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mostrarFecha();

        escuchaSelectorFecha = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                mostrarFecha();
                dia = dayOfMonth;

            }
        };

        btnEnvio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = idNombre.getText().toString();
                String direccion = idDireccion.getText().toString();
                String telefono = idTelefono.getText().toString();
                String fecha = campofecha.getText().toString();
                Intent intent = new Intent(MainActivity.this, Formulario2.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                intent.putExtra("telefono", telefono);
                intent.putExtra("fecha", fecha);
                startActivity(intent);
            }
        });


    }


    protected Dialog DialogFragment(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,escuchaSelectorFecha, año, mes, dia);
        }
        return null;
    }

    public void mostrarCalendario (View control){
        setVisible(true);
    }

    public void mostrarFecha(){
        campofecha.setText(dia+"/"+(mes+1)+"/"+año);
    }
}
