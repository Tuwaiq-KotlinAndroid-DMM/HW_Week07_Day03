package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET

interface IMovieApi {

    @GET("/demos/marvel/")
    fun getMovieData(): Call<List<MovieDataModel>>
}