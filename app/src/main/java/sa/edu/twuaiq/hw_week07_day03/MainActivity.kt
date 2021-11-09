package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val marvel = mutableListOf<MarvelModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marvelrecyclerView : RecyclerView = findViewById(R.id.Marvel_RecyclerView)
        val marvelAdapter = MarvelAdapter(marvel)

        marvelrecyclerView.adapter = marvelAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val marvelApi = retrofit.create(MarvelApi::class.java)

        marvelApi.getListMarvel(5).enqueue(object  : Callback<List<MarvelModel>>{
            override fun onResponse(
                call: Call<List<MarvelModel>>,
                response: Response<List<MarvelModel>>
            ) {
                response.body()?.run {
                    marvel.addAll(this)
                    marvelAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MarvelModel>>, t: Throwable) {
            }

        })
        }
        }

