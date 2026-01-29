package com.example.project_application.backend.Database;

import com.example.project_application.backend.Model.Item;
import com.example.project_application.backend.Model.UserModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SupabaseApi {
    @GET("/rest/v1/{table_name}")
    Call<List<Map<String, Object>>> getData(
            @Path("table_name") String table, // Сюда пишем "users", "orders" и т.д.
            @QueryMap Map<String, String> filters // Тут фильтры типа "id=eq.1"
    );

    @POST("rest/v1/{table_name}")
    Call<Void> insertData(
            @Path("table_name") String table,
            @Body Object data // Сюда кидаем наш объект (User, Task и т.д.)
    );

    @POST("rest/v1/Users")
    Call<Void> addUser(@Body UserModel user);

    @GET("rest/v1/Users")
    Call<List<UserModel>> getUser(
            @Query("email") String email,
            @Query("password") String password,
            @Query("select") String select
    );
}
