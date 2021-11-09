package com.example.marvelmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelmoviesimport.MarvelAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val marvelMovies = mutableListOf<MarvelModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marvelRecyclerView:RecyclerView = findViewById(R.id.recyclerview)
        val marvelAdapter = MarvelAdapter(marvelMovies,this)

        marvelRecyclerView.adapter = marvelAdapter

        //Retrofit.Builder
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Builder API
        val marvelAbi = retrofit.create(IMarvelApi::class.java)

        //Calling the API Methods and handles the result
        marvelAbi.getMarvelMovies().enqueue(object : Callback<List<MarvelModel>>{
            override fun onResponse(
                call: Call<List<MarvelModel>>,
                response: Response<List<MarvelModel>>
            ) {
                response.body()?.run {
                    marvelMovies.addAll(this)
                    marvelAdapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<List<MarvelModel>>, t: Throwable) {

            }

        })



    }
}