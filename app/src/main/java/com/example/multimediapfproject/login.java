package com.example.multimediapfproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin, buttonRegis;


    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegis = findViewById(R.id.buttonRegis);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Replace the following condition with your actual login logic
                if (username.isEmpty()) {
                    Toast.makeText(login.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(login.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                } else {
                    // Replace the following condition with your actual login logic
                    if (username.equals("admin") && password.equals("password")) {
                        Toast.makeText(login.this, "Login failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login.this, "Login success", Toast.LENGTH_SHORT).show();
                    }
                    if (username.length() > 0 && password.length() > 8) {
                        Intent intent1 = new Intent(login.this, MainActivity.class);
                        startActivity(intent1);
                    }
                }
            }
        });
        buttonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this , register.class);
                startActivity(intent);
            }
        });

        // Request the necessary permissions at runtime
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
    }
}