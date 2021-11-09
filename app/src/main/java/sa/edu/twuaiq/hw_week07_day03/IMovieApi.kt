package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET
import sa.edu.twuaiq.hw_week07_day03.model.MovieModel

interface IMovieApi {
    @GET("/demos/marvel/")
    fun getMovies(): Call<List<MovieModel>>
}