package com.example.marvelrecyclerapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelrecyclerapiimport.MarvelRecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val movies = mutableListOf<MoveModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val movieRecyclerview : RecyclerView = findViewById(R.id.movie_RecyclerView)
        val moviesAdapter = MarvelRecyclerView (movies)

        movieRecyclerview.adapter = moviesAdapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val movieApi = retrofit.create(MarvelApi::class.java)

        movieApi.getlistMov(1).enqueue(object : Callback<List<MoveModel>> {
            override fun onResponse(
                call: Call<List<MoveModel>>,
                response: Response<List<MoveModel>>
            ) {

                response.body()?.run {
                    movies.addAll(this)
                    moviesAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MoveModel>>, t: Throwable) {
            }

        }
        )
    }







    }
