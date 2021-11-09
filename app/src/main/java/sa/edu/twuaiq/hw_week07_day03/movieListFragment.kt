package sa.edu.twuaiq.hw_week07_day03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03.adapter.MovieAdapter
import sa.edu.twuaiq.hw_week07_day03.model.MovieModel

class movieListFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels()
    private val movies = mutableListOf<MovieModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.movie_recyclerview)
        val movieAdapter = MovieAdapter(movies, movieViewModel)

        moviesRecyclerView.adapter = movieAdapter

        // API stuff
        val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val movieApi = retrofit.create(IMovieApi::class.java)

        movieApi.getMovies().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response.body()?.run {
                    movies.addAll(this)
                    movieAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
            }
        })
    }

}