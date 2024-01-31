package com.example.bookmeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Car extends AppCompatActivity {
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        init();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Car.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init()
    {
        ivBack = findViewById(R.id.ivBack);
    }

}