package com.example.project_application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Zastavka extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zastavka);

        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        String savedPin = preferences.getString("user_pin",null);

        //если пин нулевой, пользоваетль еще не зарегестрирован, отправляем на вход
        if (savedPin == null) {
            startActivity(new Intent(this, SignIn.class));
            //если залогинен, то пусть идет вводит пин
        } else {
            startActivity(new Intent(this, Vhod.class));
        }
    }
}
