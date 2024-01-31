package com.example.bookmeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageView ivBooked, ivBus, ivAirline, ivTrain, ivCar, ivEvent, ivMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ivBooked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Booked.class);
                startActivity(intent);
            }
        });

        ivBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Buses.class);
                startActivity(intent);
            }
        });

        ivAirline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Airline.class);
                startActivity(intent);
            }
        });

        ivTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Train.class);
                startActivity(intent);
            }
        });

        ivCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Car.class);
                startActivity(intent);
            }
        });

        ivEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Event.class);
                startActivity(intent);
            }
        });

        ivMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Movies.class);
                startActivity(intent);
            }
        });






    }

    public void init()
    {
        ivBooked = findViewById(R.id.ivBooked);
        ivBus = findViewById(R.id.ivBus);
        ivAirline = findViewById(R.id.ivAirline);
        ivTrain = findViewById(R.id.ivTrain);
        ivCar = findViewById(R.id.ivCar);
        ivEvent = findViewById(R.id.ivEvent);
        ivMovies = findViewById(R.id.ivMovies);
    }
}