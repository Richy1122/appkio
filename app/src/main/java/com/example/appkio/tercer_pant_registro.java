package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class tercer_pant_registro extends AppCompatActivity {


    Button BotonSiembra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_pant_registro);


        BotonSiembra=findViewById(R.id.BotonSiembra);

        BotonSiembra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(tercer_pant_registro.this, segunda_pant_ajustes.class);
                startActivity(i);
            }
        });


    }
}