package com.leonooore.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public static final String USER_ADMIN = "admin";
    public static final String PASSWORD_ADMIN = "123123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.viewEditTextLogin);
        TextView password = findViewById(R.id.viewEditTextPassword);

        MaterialButton login = findViewById(R.id.buttonLogin);

        login.setOnClickListener(view -> {
            if(user.getText().toString().equals(USER_ADMIN) && password.getText().toString().equals(PASSWORD_ADMIN)) {
                //correct
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            } else
                //incorrect
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
        });

    }
}