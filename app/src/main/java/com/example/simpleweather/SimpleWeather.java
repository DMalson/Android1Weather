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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleweather);

        final TextView locationView = findViewById(R.id.textLocation);
        final TextView temperatureView = findViewById(R.id.textTemperature);

        final Resources res = this.getApplicationContext().getResources();
        if (savedInstanceState==null){
            locationView.setText(res.getString(R.string.location1));
            temperatureView.setText(res.getString(R.string.temp1));
        }
        Button button1 = findViewById(R.id.testChange);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locationView.getText().equals(res.getString(R.string.location1))) {
                    locationView.setText(res.getString(R.string.location2));
                    temperatureView.setText(res.getString(R.string.temp2));
                } else {
                    locationView.setText(res.getString(R.string.location1));
                    temperatureView.setText(res.getString(R.string.temp1));
                }
            }
        });

    }

}


