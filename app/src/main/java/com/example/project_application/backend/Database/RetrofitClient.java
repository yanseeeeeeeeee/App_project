package com.example.project_application.backend.Database;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Класс для доступа к базе данных
 */
public class RetrofitClient {
    private static final String BASE_URL = "https://vwbctvjmcjypcbmfocrg.supabase.co";
    private static Retrofit retrofit = null;

    public static SupabaseApi getApiService() {

        if (retrofit == null) {

            // Создаем клиент, который добавляет заголовки
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new SupabaseInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient) // Добавляем клиент
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(SupabaseApi.class);
    }
}
