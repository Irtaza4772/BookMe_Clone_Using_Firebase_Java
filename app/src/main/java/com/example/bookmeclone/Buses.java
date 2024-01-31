package com.example.bookmeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Buses extends AppCompatActivity {
    ImageView ivBack;

    TextInputEditText etBusFrom, etBusTo, etBusDate;
    Button btnSearchBus;

    String busDate, busFrom, busTo;

    RecyclerView rvBus;

    BusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);

        init();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buses.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnSearchBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                busDate = etBusDate.getText().toString().trim();
                busFrom = etBusFrom.getText().toString().trim();
                busTo = etBusTo.getText().toString().trim();


            }
        });


    }

    public void init()
    {
        ivBack = findViewById(R.id.ivBack);
        rvBus = findViewById(R.id.rvBus);
        etBusFrom = findViewById(R.id.etBusFrom);
        etBusTo = findViewById(R.id.etBusTo);
        etBusDate = findViewById(R.id.etBusDate);
        btnSearchBus = findViewById(R.id.btnSearchBus);

       /* FirebaseDatabase.getInstance().getReference().child("Buses").child("bus1").child("From").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(Buses.this, snapshot.getValue(String.class)+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Buses");

        FirebaseRecyclerOptions<Bus> options =
                new FirebaseRecyclerOptions.Builder<Bus>()
                        .setQuery(query, Bus.class)
                        .build();

        adapter = new BusAdapter(options);//, this, busDate, busFrom, busTo);
        rvBus.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}