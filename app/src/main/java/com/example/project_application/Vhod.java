package com.example.project_application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Vhod extends AppCompatActivity {

    ImageView dot1, dot2, dot3, dot4;
    ImageButton back;
    String pinCode;
    String pin = "";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhod);
        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        pinCode = preferences.getString("user_pin", "");

        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        dot4 = findViewById(R.id.dot4);

        back = findViewById(R.id.back);

    }
    public void NumClick(View view) {
        if (pin.length() <4 ) {
            Button b = (Button) view;
            pin = pin + b.getText().toString();
            updateDots();
        } if (pin.length() ==4) {
            if (pin.equals(pinCode)) {
                Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Main.class));
            } else {
                Toast.makeText(this, "Неверный pin", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateDots() {
        dot1.setImageResource(R.drawable.bot_empty);
        dot2.setImageResource(R.drawable.bot_empty);
        dot3.setImageResource(R.drawable.bot_empty);
        dot4.setImageResource(R.drawable.bot_empty);

        if (pin.length()>=1)
            dot1.setImageResource(R.drawable.bot_ready);
        if (pin.length()>=2)
            dot2.setImageResource(R.drawable.bot_ready);
        if (pin.length()>=3)
            dot3.setImageResource(R.drawable.bot_ready);
        if (pin.length()>=4)
            dot4.setImageResource(R.drawable.bot_ready);

    }

}
