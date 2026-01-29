package com.example.project_application.backend;

import android.media.MediaRouter;

import com.example.project_application.backend.Database.RetrofitClient;
import com.example.project_application.backend.Database.SupabaseApi;
import com.example.project_application.backend.Model.UserModel;

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

    public void saveUser(UserModel user, final SimpleCallback callback) {
        api.addUser(user).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()  ) {
                    callback.onSuccess();
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getUser(String email, String password, String select, final SimpleDataCallBack callback ) {
        api.getUser(email, password, select).enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(response.isSuccessful() && response.body()!=null &&!response.body().isEmpty()) {

                    callback.onSuccess(response.body().get(0));
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                callback.onError();
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

    public interface SimpleCallback{
        void onSuccess();
        void onError();
    }

    public interface SimpleDataCallBack{
        void onSuccess(UserModel user);
        void onError();
    }
}
