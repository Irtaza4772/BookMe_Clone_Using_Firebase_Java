package com.example.bookmeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Booked extends AppCompatActivity {

    ImageView ivHomeBack;

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
    }
}