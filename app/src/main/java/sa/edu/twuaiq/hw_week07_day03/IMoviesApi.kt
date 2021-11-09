package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMoviesApi {
    @GET("/demos/marvel")
    fun getMovies(

    ):Call<List<MoviesModel>>
}