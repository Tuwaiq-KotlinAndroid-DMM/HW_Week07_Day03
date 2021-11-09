package com.example.jsonarry

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import sa.edu.twuaiq.hw_week07_day03.ProductModel

interface IProductsApi {

    @GET("/demos/marvel")
    fun getListProducts(
    ):Call<List<ProductModel>>

}