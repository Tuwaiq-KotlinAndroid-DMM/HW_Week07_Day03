package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03.MovieRecyclerView

class MainActivity : AppCompatActivity() {
    private val movies = mutableListOf<MovieName>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movieRecyclerView: RecyclerView = findViewById(R.id.movie_recyclerView)
        val movieAdapter = MovieRecyclerView(movies)

        movieRecyclerView.adapter = movieAdapter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieApi = retrofit.create(MovieApi::class.java)
        movieApi.getListMovie().enqueue(object :Callback<List<MovieName>>{
            override fun onResponse(
                call: Call<List<MovieName>>,
                response: Response<List<MovieName>>
            ) {
               response.body()?.run {
                   movies.addAll(this)
                   movieAdapter.notifyDataSetChanged()
               }
            }

            override fun onFailure(call: Call<List<MovieName>>, t: Throwable) {

            }


        })
}}