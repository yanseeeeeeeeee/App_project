package com.example.project_application.backend.Database;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SupabaseInterceptor implements Interceptor {
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ3YmN0dmptY2p5cGNibWZvY3JnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Njk0MDA2NjksImV4cCI6MjA4NDk3NjY2OX0.1eM6iBd2VzuNKrGXotiRI-crsoz6qDprK3kTtIHs2fY";

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();

        // Клеим заголовки ко всем запросам автоматически
        Request.Builder requestBuilder = original.newBuilder()
                .header("apikey", API_KEY)
                .header("Authorization", "Bearer " + API_KEY) // Если юзер не залогинен, шлем ключ. Если залогинен — его JWT.
                .header("Content-Type", "application/json");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
