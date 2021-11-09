package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val movies = mutableListOf<MovieModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val MovieRecyclerView:RecyclerView = findViewById(R.id.movie_recyclerView)
        val MovieAdapter = MovieRecyclerView(movies)

        MovieRecyclerView.adapter = MovieAdapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieApi = retrofit.create(MovieApi::class.java)

        movieApi.getListMovie().enqueue(object : Callback<List<MovieModel>>{
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response.body()?.run {

                    movies.addAll(this)
                    MovieAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {

            }

        })




    }
}