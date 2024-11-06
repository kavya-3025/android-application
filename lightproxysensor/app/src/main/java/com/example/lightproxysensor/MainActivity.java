package com.example.lightproxysensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv1,tv2;
    SensorManager sensorManager;
    Sensor sensor1,sensor2;
    WebView w1,w2;

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
        tv1=(TextView) findViewById(R.id.T1);
        tv2=(TextView) findViewById(R.id.T2);
        w1=(WebView) findViewById(R.id.wv1);
        w2=(WebView) findViewById(R.id.wv2);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor1=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensor2=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            int changedvalue1= (int) sensorEvent.values[0];
            tv1.setText("Light: " +changedvalue1);
            w1.loadUrl("https://api.thingspeak.com/update?api_key=CHK1D1QELGSWJT8X&field1="+changedvalue1);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float changedvalue2 = sensorEvent.values[0];
            tv2.setText("proximity: " + changedvalue2);
            w2.loadUrl("https://api.thingspeak.com/update?api_key=CHK1D1QELGSWJT8X&field2="+changedvalue2);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor1 != null) {
            sensorManager.registerListener(this, sensor1, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensor2 != null) {
            sensorManager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,sensor1);
        sensorManager.unregisterListener(this,sensor2);

}
}
