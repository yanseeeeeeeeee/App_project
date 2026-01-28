package com.example.project_application;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        //проверка на заполненные поля для подсвеченной кнопки
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                dalee.setEnabled(!mail.isEmpty() && !pass.isEmpty());
            }
        };

        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        //переход по кнопке "регистрация"
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, Registration.class));
            }
        };
        registr.setOnClickListener(listener);

        //обработка полей для перехода на главную
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
