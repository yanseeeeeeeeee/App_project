package com.example.project_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_application.Adapters.BannerAdapter;
import com.example.project_application.Adapters.CategoryAdapter;
import com.example.project_application.Model.BannerImage;
import com.example.project_application.Model.CategoryButton;

import java.util.ArrayList;
import java.util.List;

public class home_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public home_fragment() {

    }

    List<BannerImage> listBanner;



    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
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
        //настройка рекуклера с баннерами
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        RecyclerView bannerRecycler = view.findViewById(R.id.BannerRecycler);
        initializeListBanner();
        BannerAdapter adapter = new BannerAdapter(requireContext(), listBanner);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        bannerRecycler.setAdapter(adapter);
        bannerRecycler.setLayoutManager(layoutManager);

        /*//Настройка рекуклера с категориями
        RecyclerView categoryRecycler = view.findViewById(R.id.CategoryRecycler);
        initializeListCategory();
        CategoryAdapter adapter1 = new CategoryAdapter(requireContext(), listButton);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecycler.setAdapter(adapter1);
        categoryRecycler.setLayoutManager(layoutManager1);*/








        return view;
    }

    //инициализация листа с баннерами
    private void initializeListBanner() {
        listBanner.add(new BannerImage(R.drawable.banner));
        listBanner.add(new BannerImage(R.drawable.banner_2));
    }





}