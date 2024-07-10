package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.DayOfWeek;
import java.time.MonthDay;
import java.time.Year;
import java.util.Calendar;
import java.util.HashMap;

public class segunda_pant_ajustes extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout inicio, ajuste, compartir, informacion, salir;
    Button BotonFecha, BotonHora,RegistrarBoton,BotonTerreno;
    EditText EditFecha, EditHora, IngresaNombreSiemb, CantCompra, Fecha, Hora;
    private int dia,mes,año,hora,minutos;
    private Spinner spinner1;
    private TextView textspiner;
    private HashMap<String,String> Registro;
    //private CardView PrimerImagCard, SegundImagCard, TercerImagCard, CuartoImagCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pant_ajustes);

        drawerLayout=findViewById(R.id.drawercontenedor);
        menu =findViewById(R.id.img_menu);
        inicio=findViewById(R.id.home);
        ajuste=findViewById(R.id.ajuste);
        compartir=findViewById(R.id.compartir);
        informacion=findViewById(R.id.informacion);
        salir=findViewById(R.id.salir);



        BotonFecha=findViewById(R.id.buttonFecha);
        BotonHora=findViewById(R.id.botonHora);
        EditFecha=findViewById(R.id.editTextFecha);
        EditHora=findViewById(R.id.editTextHora);

        spinner1=findViewById(R.id.spinner);
        RegistrarBoton=findViewById(R.id.buttonEntrar);
        textspiner=findViewById(R.id.MostrarTodo);
        Registro = new HashMap<>();

        //PrimerImagCard=findViewById(R.id.cardviewcompra1);
        //SegundImagCard=findViewById(R.id.cardviewcompra2);
        //TercerImagCard=findViewById(R.id.cardviewcompra3);
        //CuartoImagCard=findViewById(R.id.cardviewcompra4);
        BotonTerreno=findViewById(R.id.BotonTerreno);

        BotonFecha.setOnClickListener(this);
        BotonHora.setOnClickListener(this);

        IngresaNombreSiemb=findViewById(R.id.IngresaNombre);
        CantCompra=findViewById(R.id.CantCompra);
        Fecha=findViewById(R.id.editTextFecha);
        Hora=findViewById(R.id.editTextHora);

        BotonTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(segunda_pant_ajustes.this, tercer_pant_registro.class);
                startActivity(i);
            }
        });


        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.spinner_cuidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        //boton para registrar la seleccion

        RegistrarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seleccion = spinner1.getSelectedItem().toString();
                registrarSeleccion(seleccion);



            }

        });





        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(segunda_pant_ajustes.this, pantalla_1.class);
            }

        });
        ajuste.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                recreate();
            }

        });
        compartir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(segunda_pant_ajustes.this, tercer_pant_compartir.class);
            }

        });
        informacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(segunda_pant_ajustes.this, cuarta_pant_informacion.class);
            }

        });
        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(segunda_pant_ajustes.this, "salir", Toast.LENGTH_SHORT);
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

    @Override
    public void onClick(View i) {
        if(i ==BotonFecha){
            final Calendar c=Calendar.getInstance();
            dia= c.get(Calendar.DAY_OF_MONTH);
            mes= c.get(Calendar.MONTH);
            año= c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int Semanas, int Meses, int Años) {

                    EditFecha.setText(Semanas +"/"+(Meses +1)+"/"+ Años);
                }
            }
            ,dia,mes,año);
            datePickerDialog.show();


        }
        if(i ==BotonHora){
            final Calendar c=Calendar.getInstance();
            hora= c.get(Calendar.HOUR_OF_DAY);
            minutos= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int Horas, int Minut) {
                    EditHora.setText(Horas+":"+Minut);
                }
            },hora,minutos,false);
            timePickerDialog.show();


        }

    }


    private void registrarSeleccion(String seleccion){
        Registro.put(seleccion," ");
        StringBuilder registroText=new StringBuilder("registro:\n");

        for(String key:Registro.keySet()){
            registroText.append(key).append("").append(Registro.get(key)).append("\n");


        }
        textspiner.setText(registroText.toString());
    }

}