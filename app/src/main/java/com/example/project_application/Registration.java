package com.example.project_application;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_application.backend.Model.BaseModel;
import com.example.project_application.backend.Model.Models;
import com.example.project_application.backend.Model.UserModel;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText name, surname, lastName, email, date;
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
        date = findViewById(R.id.date);

        //Настройка адаптера для выпадающего списка
        String[] sexOp = {"Женский", "Мужской"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                sexOp
        );
        pol.setAdapter(arrayAdapter);

        //настройка поля для ввода даты
        date.setFocusable(false);
        date.setOnClickListener( v -> {
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Выберите дату")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();

                    datePicker.addOnPositiveButtonClickListener(selection -> {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                        date.setText(sdf.format(new Date(selection)));
                    });

                    datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        //отслеживание заполненных полей для активности кнопки
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String namee = name.getText().toString();
                String surnamee = surname.getText().toString();
                String lastNamee = lastName.getText().toString();
                String mail = email.getText().toString();
                String poll = pol.getText().toString();

                dalee.setEnabled(!namee.isEmpty() && !surnamee.isEmpty() && !lastNamee.isEmpty() &&
                        !mail.isEmpty() && !poll.isEmpty());

            }
        };

        name.addTextChangedListener(textWatcher);
        surname.addTextChangedListener(textWatcher);
        lastName.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        pol.addTextChangedListener(textWatcher);



        //Обработчик кнопки "Далее"
        dalee.setOnClickListener(v -> {
            String mail = email.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    Toast.makeText(this, "Неккоректный email", Toast.LENGTH_SHORT).show();
                } else {
                    UserModel user = new UserModel();
                    user.setName(name.getText().toString().trim());
                    user.setSurname(surname.getText().toString().trim());
                    user.setLastName(lastName.getText().toString().trim());
                    user.setDate(date.getText().toString().trim());
                    user.setEmail(email.getText().toString().trim());
                    user.setSex(pol.getText().toString().trim());

                    Models.save.put("user", user);
                    Gson gson = new Gson();
                    String userData = gson.toJson(user);

                    getSharedPreferences("AppPrefs", MODE_PRIVATE).edit().putString("user_data", userData).apply();

                    startActivity(new Intent(Registration.this, CreatePassword.class));
                }
        });



    }
}
