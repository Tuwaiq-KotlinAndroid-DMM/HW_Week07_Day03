package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03import.MoviesAdapter

class MainActivity : AppCompatActivity() {
    private val movies = mutableListOf<MoviesModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycleview)
        val moviesAdapter  = MoviesAdapter(movies)
        recyclerView.adapter = moviesAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val moviesApi = retrofit.create(IMoviesApi::class.java)

        moviesApi.getMovies().enqueue(object : Callback<List<MoviesModel>>{
            override fun onResponse(
                call: Call<List<MoviesModel>>,
                response: Response<List<MoviesModel>>
            ) {
                response.body()?.run {
                    movies.addAll(this)
                    moviesAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MoviesModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}