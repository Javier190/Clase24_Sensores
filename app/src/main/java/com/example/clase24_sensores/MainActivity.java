package com.example.clase24_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;


//Programa Funcional de Uso de Sensores

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    List<Sensor> sensorList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esto es para hacer el listado de sensores que tiene un dispositivo movil

        //1. Agregar el Sensor Manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //2. Crear una lista para guardar los sensores disponibles
        sensorList = sensorManager.getSensorList(-1); // es lo mismo que colocar Sensor.TYPE_ALL

        //3. Crear una variable de tipo ListView para utilizar el elemento ListView del activity
        listView = (ListView) findViewById(R.id.lsvSensores);
        LinkedList<String> linkedList = new LinkedList<>();

        for(Sensor s: sensorList) {
            linkedList.add(s.getName() + "[" + s.toString() + "]");
        }

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                                                android.R.layout.simple_list_item_1, linkedList);
        listView.setAdapter(listAdapter);
    }

    public void click(View view) {
        Intent intent = new Intent(this,SensorActivity.class);
        startActivity(intent);
    }
}