package com.example.bookmeclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Airline extends AppCompatActivity {
    ImageView ivBack;

    TextInputEditText etPlainFrom, etPlainTo, etPlainDate;
    Button btnSearchPlain;

    String PlainDate, PlainFrom, PlainTo;

    RecyclerView rvAirline;

    PlainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airline);


        init();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Airline.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSearchPlain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlainDate = etPlainDate.getText().toString().trim();
                PlainFrom = etPlainFrom.getText().toString().trim();
                PlainTo = etPlainTo.getText().toString().trim();


            }
        });


    }

    public void init()
    {
        ivBack = findViewById(R.id.ivBack);
        rvAirline = findViewById(R.id.rvAirline);
        etPlainFrom = findViewById(R.id.etPlainFrom);
        etPlainTo = findViewById(R.id.etPlainTo);
        etPlainDate = findViewById(R.id.etPlainDate);
        btnSearchPlain = findViewById(R.id.btnSearchPlain);


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Plaines");

        FirebaseRecyclerOptions<Plain> options =
                new FirebaseRecyclerOptions.Builder<Plain>()
                        .setQuery(query, Plain.class)
                        .build();

        adapter = new PlainAdapter(options, this);
        rvAirline.setAdapter(adapter);

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