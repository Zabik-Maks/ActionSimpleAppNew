package com.mirea.kt.actionsimpleappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btnStartActivity);
        btnStart.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        });
    }


}