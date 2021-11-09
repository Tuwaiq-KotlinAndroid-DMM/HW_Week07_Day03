package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET

interface IMoviesAPI {


    @GET("/demos/marvel/")

    //function to get the movies from json
    fun getMovieList(): Call<List<MoviesModel>>
}