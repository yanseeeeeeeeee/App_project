package com.example.project_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.project_application.Adapters.BannerAdapter;
import com.example.project_application.Adapters.CategoryAdapter;
import com.example.project_application.DataBase.Item;
import com.example.project_application.DataBase.SupaBaseClient;
import com.example.project_application.Model.BannerImage;
import com.example.project_application.Model.CategoryButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public home_fragment() {

    }

    List<BannerImage> listBanner = new ArrayList<>();
    Button button;



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
        bannerRecycler.setNestedScrollingEnabled(false);
        initializeListBanner();
        BannerAdapter adapter = new BannerAdapter(requireContext(), listBanner);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        bannerRecycler.setAdapter(adapter);
        bannerRecycler.setLayoutManager(layoutManager);

        /*RecyclerView categoryRecycler = view.findViewById(R.id.CategoryRecycler);
        initializeListCategory();
        CategoryAdapter adapter1 = new CategoryAdapter(requireContext(), listButton);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecycler.setAdapter(adapter1);*/

        button = view.findViewById(R.id.all);
        button.setOnClickListener(v -> fetchData());

        return view;
    }

    //инициализация листа с баннерами
    private void initializeListBanner() {
        listBanner.add(new BannerImage(R.drawable.banner));
        listBanner.add(new BannerImage(R.drawable.banner_2));
    }

    /**
     * Получение данных из базы данных
     */
    private void fetchData() {
        // Просто вызываем метод без параметров
        SupaBaseClient.getApiService().getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                Log.d("API_DEBUG", "Код ответа: " + response.code());

                if (response.isSuccessful() && response.body() != null) {
                    // ... ваш код обработки ...
                    Log.d("Database", "Успешно получено элементов: " + response.body().size());

                    List<Item> items = response.body();

                    for (var item : items) {
                        Log.d("API_DEBUG", "Данные: " + item.getTitle() + ", " + item.getType() + ", " + item.getPrice());
                    }
                } else {
                    try {
                        // Теперь это покажет реальный JSON ошибки (например, неверное имя колонки)
                        Log.e("API_DEBUG", "Детали: " + response.errorBody().string());
                    } catch (IOException e) { e.printStackTrace(); }
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.e("API_DEBUG", "Ошибка: " + t.getMessage());
            }
        });
    }
}