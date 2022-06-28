package com.leonooore.loginapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        val = getIntent().getStringExtra("USER_NAME");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Hello" + " " + val + "!", Toast.LENGTH_SHORT).show();
    }
}


