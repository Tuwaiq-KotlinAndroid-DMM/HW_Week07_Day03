package com.example.marvelmoviesapp

import retrofit2.Call
import retrofit2.http.GET

interface IProductsApi {


    @GET("/demos/marvel")
    fun getListProducts(): Call<List<ProductModelItem>>
}