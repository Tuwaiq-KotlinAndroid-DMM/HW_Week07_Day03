package sa.edu.twuaiq.hw_week07_day03

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {



    @GET("/demos/marvel/")
    fun getListMovie():retrofit2.Call<List<MovieModel>>
}