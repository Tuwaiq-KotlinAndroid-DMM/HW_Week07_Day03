package com.example.hw_week7day3

import retrofit2.Call
import retrofit2.http.GET

interface marvelApi {

    @GET("/demos/marvel/")
    fun getListMarvel():Call<List<MarvelModel>>
}