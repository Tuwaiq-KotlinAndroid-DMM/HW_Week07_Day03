package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val movie = mutableListOf<Movies>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesRecyclrView: RecyclerView = findViewById(R.id.RecyclerView)
        val moviesAdapter = MoviesRecyclerAdapter(movie)
        moviesRecyclrView.adapter = moviesAdapter
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieAoi = retrofit.create(IMoviesAPI::class.java)
        movieAoi.getMovie().enqueue(object : Callback<List<Movies>> {
            override fun onResponse(
                call: Call<List<Movies>>,
                response: Response<List<Movies>>
            ) {
                response.body()?.run{
                    movie.addAll(this)
                    moviesAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}