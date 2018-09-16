package com.example.deepak.prototype2;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StepsCounter extends AppCompatActivity implements SensorEventListener
{
    SensorManager sensorManager;
    boolean running = false;

    float initSteps = 0.0f;
    int stepsGoal, caloriesGoal;
    int totalSteps;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        pref = getApplicationContext().getSharedPreferences("StepsPref", 0); // 0 - for private mode

        if(pref.contains("TOTAL_STEPS"))
        {
            totalSteps = pref.getInt("TOTAL_STEPS",0);
            System.out.println("\n\n\nFOUND OLD:"+totalSteps);
        }
        else {
            totalSteps = 0;
            System.out.println("NOT FOUND");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null)
        {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        running=false;

//        sensorManager.unregisterListener(this);
    }

    int prevSteps = 0;
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        System.out.println("steps: "+totalSteps);
        if(initSteps < 1)
        {
            initSteps = event.values[0];
//            prevSteps = totalSteps;
            prevSteps = 0;
        }
        if(running)
        {
//          int newSteps =(int)((((int)(event.values[0] - initSteps)) - (prevSteps*1.33))*0.75);

            int newSteps =(int)(event.values[0] - initSteps - prevSteps);
            System.out.println("InitSteps:"+initSteps+" NewSteps:"+newSteps+" TotalSteps:"+totalSteps);
            //            int newSteps =(int)((((int)(event.values[0] - initSteps)) - (prevSteps)));
            totalSteps += newSteps;
//            prevSteps = totalSteps;
            prevSteps += newSteps;
//            totalSteps = (int)((event.values[0] - initSteps)*0.8);

            saveSteps();
        }

    }

    private void saveSteps()
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("TOTAL_STEPS", totalSteps);
        editor.commit();

        System.out.println("STORED: "+ pref.getInt("TOTAL_STEPS",999));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }


    public String getCurrentDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        Date date = new Date();
        return  (formatter.format(date));
    }
}
