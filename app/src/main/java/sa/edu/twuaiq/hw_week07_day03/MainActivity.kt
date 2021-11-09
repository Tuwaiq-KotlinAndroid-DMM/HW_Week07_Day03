package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val movies = mutableListOf<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieRecyclerView: RecyclerView = findViewById(R.id.movie_recyclerView)
        val moviesAapter = RecyclerViewMovieAdapter(movies)
        movieRecyclerView.adapter = moviesAapter
        // Original link : https://simplifiedcoding.net/demos/marvel/
        val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net").addConverterFactory(
            GsonConverterFactory.create()).build()
        val MoviesAPI = retrofit.create(MovieAPI::class.java)
        MoviesAPI.getMovies().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response.body()?.run {
                    Log.d("MOVIES","$this")
                    movies.addAll(this)
                    moviesAapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

    }
}