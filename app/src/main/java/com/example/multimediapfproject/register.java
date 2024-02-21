package com.example.multimediapfproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class register extends AppCompatActivity {

    RadioButton radioButton;
    private EditText editTextUsername, editTextEmail, editTextPassword, editTextConfirmPassword, editTextHeight, editTextWeight;
    private RadioGroup radioGroupGender;

    private Button buttonSignUp;

    public static String globalUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        RadioButton radioButtonMale;

        // Inisialisasi elemen UI
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(v -> {
                // Panggil fungsi validasi saat tombol Sign Up ditekan
                validateForm();

        });
    }


    private void validateForm() {
        // Ambil nilai input dari kolom form
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        String height = editTextHeight.getText().toString().trim();
        String weight = editTextWeight.getText().toString().trim();
        //String gender = radioButton.getText().toString();

        // Validasi kolom username
        if (username.isEmpty()) {
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
            globalUsername = username;
            return;
        }

        // Validasi kolom email
        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Invalid email address");
            editTextEmail.requestFocus();
            return;
        }

        // Validasi kolom password
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password should be at least 6 characters long");
            editTextPassword.requestFocus();
            return;
        }

        // Validasi kolom confirm password
        if (confirmPassword.isEmpty()) {
            editTextConfirmPassword.setError("Confirm Password is required");
            editTextConfirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            editTextConfirmPassword.setError("Passwords do not match");
            editTextConfirmPassword.requestFocus();
            return;
        }

        // Validasi kolom gender
        int checkedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1){
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validasi kolom height
        if (height.isEmpty()) {
            editTextHeight.setError("Height is required");
            editTextHeight.requestFocus();
            return;
        }

        // Validasi kolom weight
        if (weight.isEmpty()) {
            editTextWeight.setError("Weight is required");
            editTextWeight.requestFocus();
            return;
        }

        // Semua validasi berhasil, lakukan tindakan lanjutan seperti menyimpan data ke server, dll.
        // ...
        // Tampilkan pesan sukses atau alihkan ke halaman berikutnya
        Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(register.this, MainActivity.class);
         startActivity(intent);
    }
}
