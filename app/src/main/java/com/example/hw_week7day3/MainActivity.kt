package com.example.hw_week7day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_week7day3import.marvelRecyclerViewAdapter
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var moviesList= mutableListOf<MarvelModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marvelRecyclerView:RecyclerView=findViewById(R.id.marvel_recyclerView)
        val marvelAdapter=marvelRecyclerViewAdapter(moviesList)
        marvelRecyclerView.adapter=marvelAdapter

        val retrofit=Retrofit.Builder().baseUrl("https://simplifiedcoding.net").addConverterFactory(GsonConverterFactory.create()).build()
        val marvelApi=retrofit.create(marvelApi::class.java)
        marvelApi.getListMarvel().enqueue(object :Callback<List<MarvelModel>>{
            override fun onResponse(
                call: Call<List<MarvelModel>>,
                response: Response<List<MarvelModel>>
            ) {
                response.body()?.run {
                    moviesList.addAll(this)
                    marvelAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MarvelModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }



}