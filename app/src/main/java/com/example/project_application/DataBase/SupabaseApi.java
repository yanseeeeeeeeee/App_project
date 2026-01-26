package com.example.project_application.DataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SupabaseApi {
    // Убираем аргументы, так как заголовки добавит Interceptor в SupaBaseClient
    @GET("/rest/v1/Mobile?select=*")
    Call<List<Item>> getItems();
}
