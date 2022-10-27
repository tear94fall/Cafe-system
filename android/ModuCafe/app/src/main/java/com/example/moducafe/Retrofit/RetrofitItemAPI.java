package com.example.moducafe.Retrofit;

import com.example.moducafe.Adapter.CategoryDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitItemAPI {

    @GET("cafe/items/all")
    Call<List<CategoryDto>> RequestAllItems();
}
