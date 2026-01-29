package com.example.project_application;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_application.backend.Model.UserModel;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class profile_fragment extends Fragment {

    TextView back, email, name;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public profile_fragment() {}


    public static profile_fragment newInstance(String param1, String param2) {
        profile_fragment fragment = new profile_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        email = view.findViewById(R.id.email);
        name = view.findViewById(R.id.name);

        String userData = requireContext().getSharedPreferences("AppPrefs", MODE_PRIVATE).getString("user_data", null);
        if(userData !=null) {
            UserModel user = new Gson().fromJson(userData, UserModel.class);
            name.setText(user.getName());
            email.setText(user.getEmail());
        }

        //Выход из аккаунта, очистка сессии, переход на вход
        back = view.findViewById(R.id.SignOut);
        back.setOnClickListener( v -> {
            requireContext().getSharedPreferences("AppPrefs", MODE_PRIVATE)
                    .edit()
                    .clear()
                    .apply();

            Intent intent = new Intent(requireContext(), SignIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        //

        return view;
    }
}