package com.example.bookmeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView ivBooked, ivBus, ivAirline, ivTrain, ivCar, ivEvent, ivMovies;

    FloatingActionButton btnAddPlain, btnAddBus;

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

        btnAddPlain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.add_item_design, null);

                TextInputEditText etItemName = view.findViewById(R.id.etItemName);
                TextInputEditText etItemFrom = view.findViewById(R.id.etItemFrom);
                TextInputEditText etItemTo = view.findViewById(R.id.etItemTo);
                TextInputEditText etItemPrice = view.findViewById(R.id.etItemPrice);
                TextInputEditText etItemDate = view.findViewById(R.id.etItemDate);


                AlertDialog.Builder addNewItem = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add New Plain").setView(view)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = etItemName.getText().toString().trim();
                                String from = etItemFrom.getText().toString().trim();
                                String to = etItemTo.getText().toString().trim();
                                String price = etItemPrice.getText().toString().trim();
                                String date = etItemDate.getText().toString().trim();

                                HashMap<String, Object> data = new HashMap<>();
                                data.put("Name", name);
                                data.put("From", from);
                                data.put("To", to);
                                data.put("Price", price);
                                data.put("Date", date);

                                FirebaseDatabase.getInstance()
                                        .getReference().child("Plaines")
                                        .push()
                                        .setValue(data)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(MainActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                addNewItem.create();
                addNewItem.show();



            }

        });

        btnAddBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.add_item_design, null);

                TextInputEditText etItemName = view.findViewById(R.id.etItemName);
                TextInputEditText etItemFrom = view.findViewById(R.id.etItemFrom);
                TextInputEditText etItemTo = view.findViewById(R.id.etItemTo);
                TextInputEditText etItemPrice = view.findViewById(R.id.etItemPrice);
                TextInputEditText etItemDate = view.findViewById(R.id.etItemDate);


                AlertDialog.Builder addNewItem = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add New Bus").setView(view)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = etItemName.getText().toString().trim();
                                String from = etItemFrom.getText().toString().trim();
                                String to = etItemTo.getText().toString().trim();
                                String price = etItemPrice.getText().toString().trim();
                                String date = etItemDate.getText().toString().trim();

                                HashMap<String, Object> data = new HashMap<>();
                                data.put("Name", name);
                                data.put("From", from);
                                data.put("To", to);
                                data.put("Price", price);
                                data.put("Date", date);

                                FirebaseDatabase.getInstance()
                                        .getReference().child("Buses")
                                        .push()
                                        .setValue(data)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(MainActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                addNewItem.create();
                addNewItem.show();
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

        btnAddPlain = findViewById(R.id.btnAddPlain);
        btnAddBus = findViewById(R.id.btnAddBus);
    }

}


