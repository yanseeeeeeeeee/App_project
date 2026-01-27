package com.example.project_application;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    EditText name, surname, lastName, email;
    Button dalee;

    AutoCompleteTextView pol;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_card);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        lastName = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        dalee = findViewById(R.id.dalee);
        pol = findViewById(R.id.sex);

        String namee = name.getText().toString();
        String surnamee = surname.getText().toString();
        String lastNamee = lastName.getText().toString();
        String mail = email.getText().toString();
        String poll = pol.getText().toString();

        dalee.setOnClickListener(v -> {
            if (namee.isEmpty() || surnamee.isEmpty() || lastNamee.isEmpty() || mail.isEmpty() ||poll.isEmpty() ) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else
                if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    Toast.makeText(this, "Неккоректный email", Toast.LENGTH_SHORT).show();
                }
        });


        /*String PASSWORD_PATTERN  = "^(&=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        boolean isValid = pass.matches(PASSWORD_PATTERN);*/
    }
}
