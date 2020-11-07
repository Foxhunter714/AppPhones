package com.example.firstapp.model.remote


import retrofit2.http.GET
import retrofit2.Call

interface ProductAPI {
    @GET("products")
    fun listProduct(): Call<Product>
}