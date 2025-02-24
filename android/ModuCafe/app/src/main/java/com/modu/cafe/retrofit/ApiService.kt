package com.modu.cafe.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("api/v1/login/third")
    fun loginModuChat(@Header("Authorization") token: String, @Body request: LoginRequest): Call<LoginResponse>
}