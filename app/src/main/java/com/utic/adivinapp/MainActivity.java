package com.utic.adivinapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //en esta zona se definen las variables que seran programados y siempre deben ser privadas por seguridad
    private EditText etNumero;
    private int numero;
    private String cadena;
    private Toast notificacion;
    private String numeroIngresado;
    private int numeroIngresadoEntero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //instrucciones y se escriben dentro de oncreate
        etNumero = findViewById(R.id.etNumero);
        numero = (int)(Math.random()*100000);
        cadena= String.valueOf(numero);
        notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG);
        notificacion.show();

    }
    public void verificar(View vista){
        numeroIngresado = etNumero.getText().toString();
        numeroIngresadoEntero = Integer.parseInt(numeroIngresado);
        if (numero==numeroIngresadoEntero){
            notificacion = Toast.makeText(this, "Congratulacion!", Toast.LENGTH_LONG);
            notificacion.show();
        } else {
            notificacion = Toast.makeText(this, "Incorrecto!", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}