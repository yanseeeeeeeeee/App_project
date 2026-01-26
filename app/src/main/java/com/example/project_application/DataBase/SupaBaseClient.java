package com.example.project_application.DataBase;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Класс для доступа к базе данных
 */
public class SupaBaseClient {
    private static final String BASE_URL = "https://vwbctvjmcjypcbmfocrg.supabase.co";
    private static final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ3YmN0dmptY2p5cGNibWZvY3JnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Njk0MDA2NjksImV4cCI6MjA4NDk3NjY2OX0.1eM6iBd2VzuNKrGXotiRI-crsoz6qDprK3kTtIHs2fY";
    private static Retrofit retrofit = null;

    public static SupabaseApi getApiService() {
        if (retrofit == null) {
            // Создаем клиент, который добавляет заголовки
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request request = chain.request().newBuilder()
                                .addHeader("apikey", SUPABASE_KEY)
                                .addHeader("Authorization", "Bearer " + SUPABASE_KEY)
                                .build();
                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client) // Добавляем клиент
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SupabaseApi.class);
    }
}
