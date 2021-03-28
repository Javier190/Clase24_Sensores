package com.example.clase24_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;
    EditText editTextX;
    EditText editTextY;
    EditText editTextZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        //1. Agregar el Sensor Manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //2 Aca se pone el sensor que se va a usar esta elk de accelerometro y el de proximidad
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //esto es la velocidad de refresco de la informacion creo
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        editTextX = (EditText) findViewById(R.id.txtX);
        editTextY = (EditText) findViewById(R.id.txtY);
        editTextZ = (EditText) findViewById(R.id.txtZ);
    }

    //Aca segun traduccion es el metodo que va cuando el sensor recibe el evento de cambio
    @Override
    public void onSensorChanged(SensorEvent event) {
        editTextX.setText(Float.toString(event.values[0]));
        editTextY.setText(Float.toString(event.values[1]));
        editTextZ.setText(Float.toString(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}