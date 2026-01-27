package com.example.project_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_application.Adapters.CategoryAdapter;
import com.example.project_application.Lists.Cards;
import com.example.project_application.Lists.Category;


public class katalog_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    Category category = new Category();

    public katalog_fragment() {

    }

    public static katalog_fragment newInstance(String param1, String param2) {
        katalog_fragment fragment = new katalog_fragment();
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
       View view = inflater.inflate(R.layout.katalog_fragment, container, false);

       //настройка рекуклера для категорий
        RecyclerView categoryRecycler = view.findViewById(R.id.category);
        CategoryAdapter catAdapter = new CategoryAdapter(requireContext(), category.getList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecycler.setAdapter(catAdapter);
        categoryRecycler.setLayoutManager(layoutManager);

        //настройка рекуклера для карточек




        return view;
    }
}