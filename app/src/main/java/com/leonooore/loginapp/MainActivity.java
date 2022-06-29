package com.leonooore.loginapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.button.MaterialButton;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private String enteredName;
    private String enteredPassword;

    private static final String USER_ADMIN = "Admin";
    private static final String PASSWORD_ADMIN = "123123";

    private static final String EMAIL = "email";

    private Intent intent;

    private CallbackManager callbackManager;

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

            intent = new Intent(this, SecondActivity.class).putExtra("USER_NAME",enteredName);

            if(enteredName.equals(USER_ADMIN) && enteredPassword.equals(PASSWORD_ADMIN)) {
                startActivity(intent);
                finish();
            } else
                Toast.makeText(this, "Failed, try again or sign with social media", Toast.LENGTH_SHORT).show();
        });

        initFacebookLogin();

    }

    private void initFacebookLogin() {
        FacebookSdk.fullyInitialize();
        AppEventsLogger.activateApp(getApplication());

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions(Collections.singletonList(EMAIL));

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                Log.d("CANCEL", "Cancel");
            }

            @Override
            public void onError(@NonNull FacebookException exception) {
                Log.d("ERROR", exception.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}