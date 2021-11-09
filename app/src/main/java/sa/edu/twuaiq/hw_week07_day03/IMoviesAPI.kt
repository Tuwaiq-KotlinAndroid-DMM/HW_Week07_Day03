package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET

interface IMoviesAPI {

    //https://simplifiedcoding.net/demos/marvel/
    @GET("/demos/marvel/") // ->> path
    fun getListMovies() : Call<List<MoviesModel>> //List because we have json array
}