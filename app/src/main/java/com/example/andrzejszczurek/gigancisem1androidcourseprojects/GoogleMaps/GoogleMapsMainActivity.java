package com.example.andrzejszczurek.gigancisem1androidcourseprojects.GoogleMaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andrzejszczurek.gigancisem1androidcourseprojects.R;

public class GoogleMapsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_main);

        findViewById(R.id.btn_google_map_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Przejście na aktywnośc z mapą
                Intent intent = new Intent(getApplicationContext(), GoogleMapsMapActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_google_map_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // zamknięcie aktualnej aktyności - jeżeli jest to główna aktywnoć
                // to zamknięta zostanie aplikacji
                finish();
            }
        });

    }
}
