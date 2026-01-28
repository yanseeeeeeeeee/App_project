package com.example.project_application;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class CreatePassword extends AppCompatActivity {

    EditText password, twoPassword;
    Button save;

    String pass, passTwo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_password);

        password = findViewById(R.id.password);
        twoPassword = findViewById(R.id.passwordTwo);
        save = findViewById(R.id.save);

    //Обработка загорающейся кнопки при вводе всех полей
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = password.getText().toString().trim();
                String passTwo = twoPassword.getText().toString().trim();

                save.setEnabled(!pass.isEmpty() && !passTwo.isEmpty());
            }
        };

        password.addTextChangedListener(textWatcher);
        twoPassword.addTextChangedListener(textWatcher);

    //Добавление паттерна на надежный пароль и проверка на соответствие
        pass = password.getText().toString().trim();
        passTwo = twoPassword.getText().toString().trim();

        String PASSWORD_PATTERN  = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\s!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        boolean isValid = pass.matches(PASSWORD_PATTERN);

    //Обработчик кнопки сохранить
        save.setOnClickListener(v -> {
            pass = password.getText().toString().trim();
            passTwo = twoPassword.getText().toString().trim();
            Log.d("Logi", "Полученный пароль:" + pass);


            if (!pass.matches(PASSWORD_PATTERN)) {
                Toast.makeText(this, "Пароль должен содержать заглавные и строчные буквы, цифры, пробелы и специальные символы.", Toast.LENGTH_LONG)
                        .show();
            } else if (!pass.equals(passTwo)) {
                Toast.makeText(this, "Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
