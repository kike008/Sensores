package com.example.kike.sensores;


import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.hardware.Sensor;
import java.util.List;

public class MainActivity extends ActionBarActivity implements SensorEventListener{

    private TextView lista, Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida = (TextView) findViewById(R.id.salida);

        lista = (TextView) findViewById(R.id.salida);

        Var1 = (TextView) findViewById(R.id.val1);
        Var2 = (TextView) findViewById(R.id.val2);
        Var3 = (TextView) findViewById(R.id.val3);
        Var4 = (TextView) findViewById(R.id.val7);
        Var5 = (TextView) findViewById(R.id.val8);
        Var6 = (TextView) findViewById(R.id.val9);
        Var7 = (TextView) findViewById(R.id.val10);
        Var8 = (TextView) findViewById(R.id.val13);



        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor: listaSensores) {
            log(sensor.getName());
        }
    }
    // Metodo para iniciar la escucha de los eventos de los sensores
    public void INICIAR(View v) {
        lista.setText("");
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : listaSensores) {
            log(sensor.getName());
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_LIGHT);

        if (!listaSensores.isEmpty()) {
            Sensor luzSensores = listaSensores.get(0);
            sensorManager.registerListener(this,luzSensores ,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }


    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) {
        synchronized (this) {
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ORIENTATION:
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    Var1.setText("Aceler\u00f3metro X: " + event.values[0]);
                    Var2.setText("Aceler\u00f3metro Y: " + event.values[1]);
                    Var3.setText("Aceler\u00f3metro Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    Var4.setText("Eje X: " + event.values[0]);
                    Var5.setText("Eje Y: " + event.values[1]);
                    Var6.setText("Eje Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    Var7.setText("Proximidad: " + event.values[0]);
                    break;
                case Sensor.TYPE_LIGHT:
                    Var8.setText("Sensor de luz: " + event.values[0]);
                    break;
            }
        }
    }

    private void log(String string) {
        lista.append(string + "\n");
    }


    @Override
    protected void onPause() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    public void DETENER(View v) {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }

    public void LIMPIAR(View v) {
        Var1.setText("");
        Var2.setText("");
        Var3.setText("");
        Var4.setText("");
        Var5.setText("");
        Var6.setText("");
        Var7.setText("");
        Var8.setText("");

    }

}
