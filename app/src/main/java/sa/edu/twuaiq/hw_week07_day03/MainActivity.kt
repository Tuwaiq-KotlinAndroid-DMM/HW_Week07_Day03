package sa.edu.twuaiq.hw_week07_day03


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.twuaiq.hw_week07_day03import.marveladapter


class MainActivity : AppCompatActivity() {
    private val marvellist= mutableListOf<marveljson>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycle:RecyclerView=findViewById(R.id.marvel)
        val adapter=marveladapter(marvellist)
        recycle.adapter=adapter
        val retrofit=Retrofit.Builder().baseUrl("https://simplifiedcoding.net/").addConverterFactory(GsonConverterFactory.create()).build()
        val retroapi=retrofit.create(marvelapi::class.java)

        retroapi.getmarvelinfo(5).enqueue(object:Callback<List<marveljson>>{
            override fun onResponse(
                call: Call<List<marveljson>>,
                response: Response<List<marveljson>>
            ) {
                response.body()?.run {
                    marvellist.addAll(this)
                    Log.d("Mainn",marvellist.size.toString())
                   adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<marveljson>>, t: Throwable) {

            }

        })


    }
}