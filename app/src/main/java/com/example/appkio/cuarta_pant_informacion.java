package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class cuarta_pant_informacion extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout inicio, ajuste, compartir, informacion, salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_pant_informacion);

        drawerLayout=findViewById(R.id.drawercontenedor);
        menu =findViewById(R.id.img_menu);
        inicio=findViewById(R.id.home);
        ajuste=findViewById(R.id.ajuste);
        compartir=findViewById(R.id.compartir);
        informacion=findViewById(R.id.informacion);
        salir=findViewById(R.id.salir);

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(cuarta_pant_informacion.this, pantalla_1.class);
            }

        });
        ajuste.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(cuarta_pant_informacion.this, segunda_pant_ajustes.class);
            }

        });
        compartir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(cuarta_pant_informacion.this, tercer_pant_compartir.class);            }

        });
        informacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                recreate();
            }

        });
        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(cuarta_pant_informacion.this, "salir", Toast.LENGTH_SHORT);
            }

        });

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }

    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent i = new Intent(activity, secondActivity);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
        activity.finish();
    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }
}