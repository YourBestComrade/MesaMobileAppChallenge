package com.example.mesamobileappchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ImageButton loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNumberPassword = (EditText) findViewById((R.id.editTextNumberPassword));
                TextView errorTextView = (TextView) findViewById((R.id.errorTextView));

                String passwordEntered = editTextNumberPassword.getText().toString();
                if(passwordEntered.equals(getResources().getString(R.string.password)))
                {
                    Intent intent = new Intent(LoginActivity.this, NoteActivity.class);
                    startActivity(intent);
                }
                else{
                    errorTextView.setText("Incorrect password" + "");
                }
            }
        });
    }
}