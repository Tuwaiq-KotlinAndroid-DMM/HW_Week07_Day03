package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET
//https://simplifiedcoding.net/demos/marvel/
interface MovieAPI {
@GET("/demos/marvel/")
fun getMovies():retrofit2.Call<List<MovieModel>>
}