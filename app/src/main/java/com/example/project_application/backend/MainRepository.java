package com.example.project_application.backend;

import com.example.project_application.backend.Database.RetrofitClient;
import com.example.project_application.backend.Database.SupabaseApi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private final SupabaseApi api;

    public MainRepository() {
        this.api = RetrofitClient.getApiService();
    }

    /**
     * Универсальный метод для получения списка чего угодно.
     */
    public void fetchData(String table, Map<String, String> filters, final DataCallback callback) {
        api.getData(table, filters).enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body()); // Возвращаем данные
                } else {
                    callback.onError("Ошибка: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }



    /**
     * Интерфейс для обратного вызова (чтобы Activity получила результат)
     */
    public interface DataCallback {
        void onSuccess(List<Map<String, Object>> data);
        void onError(String error);
    }
}
