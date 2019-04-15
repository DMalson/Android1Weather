package com.example.simpleweather;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleWeather extends AppCompatActivity {
    private String locationName;
    private String temperature;
    private final String LOCATION ="Location";
    private final String TEMPERATURE = "Temperature";

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        locationName=savedInstanceState.getString(LOCATION);
        temperature=savedInstanceState.getString(TEMPERATURE);
        setValues();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LOCATION,locationName);
        savedInstanceState.putString(TEMPERATURE,temperature);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleweather);

        if (savedInstanceState==null) {
            initValues();
            setValues();
        }

        Button button1 = findViewById(R.id.testChange);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                setValues();
            }
        });
    }

    protected void getValues(){
        final Resources res = getApplicationContext().getResources();
        if (locationName.equals(res.getString(R.string.location1))) {
            locationName=res.getString(R.string.location2);
            temperature=res.getString(R.string.temp2);
        } else {
            locationName=res.getString(R.string.location1);
            temperature=res.getString(R.string.temp1);
        }
    }

    protected void initValues(){
        final Resources res = getApplicationContext().getResources();
        locationName=res.getString(R.string.location1);
        temperature=res.getString(R.string.temp1);
    }

    protected void setValues(){
        final TextView locationView = findViewById(R.id.textLocation);
        final TextView temperatureView = findViewById(R.id.textTemperature);
        locationView.setText(locationName);
        temperatureView.setText(temperature);
    }
}


