package com.leonooore.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String val = getIntent().getStringExtra("USER_NAME");

        TextView viewTextHello = findViewById(R.id.viewTextHello);

        viewTextHello.setText(String.format("Hello %s!", val));
        
        Button btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            LoginManager.getInstance().logOut();
            startActivity(new Intent(SecondActivity.this, MainActivity.class));
            finish();
        });
    }

}


