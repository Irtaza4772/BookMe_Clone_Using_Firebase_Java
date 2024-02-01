package com.example.bookmeclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Booked extends AppCompatActivity {

    ImageView ivHomeBack;

    RecyclerView rvBooked;

    BookedAdapder adapder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        init();

        ivHomeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Booked.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void init()
    {
        ivHomeBack = findViewById(R.id.ivHomeBack);
        rvBooked = findViewById(R.id.rvBooked);


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Booked");

        FirebaseRecyclerOptions<Book> options =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(query, Book.class)
                        .build();

        adapder = new BookedAdapder(options);
        rvBooked.setAdapter(adapder);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapder.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapder.stopListening();
    }
}