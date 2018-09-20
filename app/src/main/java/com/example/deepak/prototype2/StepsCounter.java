package com.example.deepak.prototype2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StepsCounter implements SensorEventListener
{
    final String MASTER_STEP_COUNT_KEYNAME = "MASTER_STEP_COUNT";
    final String TOTAL_STEP_COUNT_KEYNAME = "TOTAL_STEP_COUNT";
    final String STEP_GOAL_KEYNAME = "STEP_GOAL";
    final String CALORIE_GOAL_KEYNAME = "CALORIE_GOAL";
    final String WEIGHT_KEYNAME = "WEIGHT";

    SensorManager sensorManager;
    boolean running = true;

    int stepsGoal, caloriesGoal;
    int weight;
    int master_step_count, total_step_count;

    Context context;

    public StepsCounter(Context context)
    {
        //User.clear_preferences();
        this.context = context;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);

        stepsGoal  = User.getInt(STEP_GOAL_KEYNAME, 7000);
        caloriesGoal = User.getInt(CALORIE_GOAL_KEYNAME, getCaloriesFromSteps(7000));
        weight = User.getInt(WEIGHT_KEYNAME, 50);

        total_step_count = User.getInt(TOTAL_STEP_COUNT_KEYNAME,0);
    }



    @Override
    public void onSensorChanged(SensorEvent event)
    {
//        System.out.println("HERE");
//        System.out.println("Event:"+(int)event.values[0]);
//        System.out.println("Master:"+master_step_count);

        if(User.contains(MASTER_STEP_COUNT_KEYNAME) == false)
        {
//            System.out.println("Here33");
            User.putInt(MASTER_STEP_COUNT_KEYNAME, (int)event.values[0]);
        }
        else {
            master_step_count = User.getInt(MASTER_STEP_COUNT_KEYNAME,0);
        }

//        if(initSteps < 1)
//        {
//            initSteps = event.values[0];
////            prevSteps = totalSteps;
//            prevSteps = 0;
//        }
        if(running)
        {
            total_step_count  = ((int)event.values[0]) - master_step_count;
            User.putInt(TOTAL_STEP_COUNT_KEYNAME, total_step_count);
        }

    }

    public int getCount()
    {
//        int master_steps = User.getInt(MASTER_STEP_COUNT_KEYNAME,0);;
        int steps = User.getInt(TOTAL_STEP_COUNT_KEYNAME,0);
        return (steps);
    }

    public int getCalories()
    {
        int calories = (int)(total_step_count*getCalorieMultiplier());
        return calories;
    }

    public int getCaloriesFromSteps(int steps)
    {
        int calories = (int)(steps*getCalorieMultiplier());
        return calories;
    }

    public double getCalorieMultiplier()
    {
        if(weight < 45)
            return (28.0/1000.0);
        else if(weight>=45 && weight<55)
            return (33.0/1000.0);
        else if(weight>=55 && weight<64)
            return (38.0/1000.0);
        else if(weight>=64 && weight<73)
            return (44.0/1000.0);
        else if(weight>=73 && weight<82)
            return (49.0/1000.0);
        else if(weight>=82 && weight<91)
            return (55.0/1000.0);
        else if(weight>=91 && weight<100)
            return (60.0/1000.0);
        else if(weight>=100 && weight<114)
            return (69.0/1000.0);
        else if(weight>=114 && weight<125)
            return (75.0/1000.0);
        else if(weight>=125)
            return (82.0/1000.0);
        else
            return (82.0/1000.0);
    }

    public int getStepsProgress()
    {
        int stepsProgress = (int)((total_step_count*100)/stepsGoal);

        System.out.println("Steps Count:"+total_step_count);
        System.out.println("Steps Goal:"+stepsGoal);
        System.out.println("Steps Progress:"+stepsProgress);

        if(stepsProgress>100)
            stepsProgress = 100;

        return stepsProgress;
    }

    public int getCaloriesProgress()
    {
        int caloriesProgress = (int)((getCalories()*100)/caloriesGoal);

        if(caloriesProgress>100)
            caloriesProgress = 100;

        return caloriesProgress;
    }


    private void saveSteps()
    {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putInt("TOTAL_STEPS", totalSteps);
//        editor.commit();
//
//        System.out.println("STORED: "+ pref.getInt("TOTAL_STEPS",999));
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

//class BackgroundStepsCounter extends Service{
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//}
