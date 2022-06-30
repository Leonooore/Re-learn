package com.leonooore.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginManager;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private TextView viewTextHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String name = getIntent().getStringExtra("USER_NAME");

        viewTextHello = findViewById(R.id.viewTextHello);

        if (name == null) {
            FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);
            callGraph();
        } else {
            viewTextHello.setText(String.format("Hello %s!", name));
        }

        viewTextHello.setText(String.format("Hello %s!", name));

        Button btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            LoginManager.getInstance().logOut();
            startActivity(new Intent(SecondActivity.this, MainActivity.class));
            finish();
        });
    }

    private void callGraph() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        try {
                            String userName = object.getString("name");
                            viewTextHello.setText(String.format("Hello %s!", userName));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }

}


