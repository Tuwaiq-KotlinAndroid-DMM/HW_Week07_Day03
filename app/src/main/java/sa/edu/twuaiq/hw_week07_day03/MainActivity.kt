package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03import.MovieAdapter

private val list = mutableListOf<MovieModel>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = MovieAdapter(list,this)
        val progressBar:ProgressBar = findViewById(R.id.progressBar)
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val iMarvelMovieApi = retrofit.create(IMarvelMoviesApi::class.java)

        iMarvelMovieApi.getMovies().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response.body()?.run {
                    progressBar.visibility = View.INVISIBLE
                    list.addAll(this)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
            }

        })


    }
}