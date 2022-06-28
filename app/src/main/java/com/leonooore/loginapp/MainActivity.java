package com.leonooore.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private String enteredName;
    private String enteredPassword;

    public static final String USER_ADMIN = "Admin";
    public static final String PASSWORD_ADMIN = "123123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.viewEditTextLogin);
        TextView password = findViewById(R.id.viewEditTextPassword);

        MaterialButton button = findViewById(R.id.buttonLogin);

        button.setOnClickListener(view -> {
            enteredName = user.getText().toString();
            enteredPassword =  password.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class).putExtra("USER_NAME",enteredName);

            if(enteredName.equals(USER_ADMIN) && enteredPassword.equals(PASSWORD_ADMIN)) {
                startActivity(intent);
            } else
                Toast.makeText(this, "Failed, try again or sign with social media", Toast.LENGTH_SHORT).show();
        });

    }
}