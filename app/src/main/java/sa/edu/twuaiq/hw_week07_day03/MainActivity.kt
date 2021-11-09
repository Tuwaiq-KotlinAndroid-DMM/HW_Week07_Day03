package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val movies = mutableListOf<MoviesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesRecyclerview : RecyclerView = findViewById(R.id.movies_recyclerview)
        val moviesAdapter = MoviesRecyclerViewAdapter(movies)

        moviesRecyclerview.adapter = moviesAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val moviesApi = retrofit.create(IMoviesAPI::class.java)

        moviesApi.getListMovies().enqueue(object : Callback<List<MoviesModel>> {
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

            }


        })
    }
}