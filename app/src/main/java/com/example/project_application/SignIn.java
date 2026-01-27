package com.example.project_application;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    EditText email, password;
    Button dalee;
    TextView registr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhod_registr);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        dalee = findViewById(R.id.dalee);
        registr = findViewById(R.id.registration);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, Registration.class));
            }
        };

        registr.setOnClickListener(listener);

        dalee.setOnClickListener(v -> {
            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                Toast.makeText(this, "Неккоректный email", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(SignIn.this, Main.class));
            }
        });
    }
}
