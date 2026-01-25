package com.example.project_application;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bot_menu);
        BottomNavigationView bottomMenu = findViewById(R.id.bottomNavigationView);

        //дефолтный фрагмент
        if (savedInstanceState == null) {
            LoadFragment(new home_fragment());
        }

        //выборка по нижнему меню
        bottomMenu.setOnItemSelectedListener(item->{
            Fragment fragment = null;
            int id = item.getItemId();

            if (id == R.id.home) {
                fragment = new home_fragment();
            } else if (id == R.id.katalog) {
                fragment = new katalog_fragment();
            } else if (id == R.id.project) {
                fragment = new project_fragment();
            } else if (id == R.id.profile) {
                fragment = new profile_fragment();
            }
            return true;
        });

    }

    //метод для загрузки фрагментов
    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
