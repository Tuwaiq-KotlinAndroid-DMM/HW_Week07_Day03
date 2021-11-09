package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03import.MarvelRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private val marvelmovies = mutableListOf<MarvelModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val marvelRecyclerView: RecyclerView = findViewById(R.id.marvel_recyclerview)
        val marvelAdapter = MarvelRecyclerViewAdapter (marvelmovies)

         marvelRecyclerView.adapter = marvelAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val marvelApi = retrofit.create(MarvelApi::class.java)


        marvelApi.getListMarvel(5).enqueue(object : Callback<List<MarvelModel>>{
            override fun onResponse(
                call: Call<List<MarvelModel>>,response: Response<List<MarvelModel>>
            ) {
                response.body()?.run {
                    marvelmovies.addAll(this)
                    marvelAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MarvelModel>>, t: Throwable) {

            }

        })
    }
}