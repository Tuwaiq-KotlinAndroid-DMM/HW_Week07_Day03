package com.example.marvelrecyclerapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/demos/marvel/")
    fun getlistMov(@Query ("limit") limit : Int ): Call<List<MoveModel>>

}
