package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText user,password;
    Button logear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_inicio);

        user=(EditText)findViewById(R.id.editTUsuario);
        password=(EditText)findViewById(R.id.editTPassword);
        logear=(Button)findViewById(R.id.buttonEntrar);

        logear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.getText().toString().equals(""))
                {
                    Toast.makeText(login.this, "es necesario tus credenciales para continuar", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().equals("")) {
                    Toast.makeText(login.this, "Ingresa alguna contraseña", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().length()<6) {
                    Toast.makeText(login.this, "La contrasela debe ser mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(login.this, pantalla_1.class);
                    startActivity(i);

                }
            }
        });



    }
}