package com.example.marvelmovies

import retrofit2.Call
import retrofit2.http.GET

interface IMarvelApi {

    @GET("/demos/marvel/")
    fun getMarvelMovies(): Call<List<MarvelModel>>
}