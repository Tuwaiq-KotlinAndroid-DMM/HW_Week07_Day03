package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03import.MovieRcyclerAdapter

class MainActivity : AppCompatActivity() {
    private val moviesList= mutableListOf<MovieDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieRecyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val movieAdapter = MovieRcyclerAdapter(moviesList)

        movieRecyclerView.adapter = movieAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieApi = retrofit.create(IMovieApi::class.java)
        movieApi.getMovieData().enqueue(object: Callback<List<MovieDataModel>>{
            override fun onResponse(
                call: Call<List<MovieDataModel>>,
                response: Response<List<MovieDataModel>>
            ) {
                response.body()?.run {
                    moviesList.addAll(this)
                    movieAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MovieDataModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}