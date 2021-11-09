package sa.edu.twuaiq.hw_week07_day03

import retrofit2.http.GET

interface MovieApi {
    @GET("/demos/marvel")
    fun getListMovie():
            retrofit2.Call<List<MovieName>>
}