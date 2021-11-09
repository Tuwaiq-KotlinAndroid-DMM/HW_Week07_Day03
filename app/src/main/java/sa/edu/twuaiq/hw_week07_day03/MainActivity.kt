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

    private val movies = mutableListOf<MoviesModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// calling the recyclerview and assigning its adapter to it
        val recyclerview: RecyclerView = findViewById(R.id.movies_recyclerview)
        val moviesAdapter = MoviesAdapter(movies)
        recyclerview.adapter = moviesAdapter


        // build the retrofit

        val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create()).build()


        // build the API

        val moviesAPI = retrofit.create(IMoviesAPI:: class.java)
// using the API function to display the enqueue
        moviesAPI.getMovieList().enqueue(object: Callback<List<MoviesModel>>{

            override fun onResponse(
                call: Call<List<MoviesModel>>,
                response: Response<List<MoviesModel>>,
            ) {
                response.body()?.run {

                    //adding tne elements to the list
                    movies.addAll(this)
                    moviesAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MoviesModel>>, t: Throwable) {

            }


        })

    }
}