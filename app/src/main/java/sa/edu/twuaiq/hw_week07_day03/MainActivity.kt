package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonarry.IProductsApi
import com.example.jsonarryimport.ProductsRecyclerViewAdapter
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val demos= mutableListOf<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        




        val productRecyclerView: RecyclerView = findViewById(R.id.product_recyclerview)
        val productsAdapter = ProductsRecyclerViewAdapter(demos)

        productRecyclerView.adapter = productsAdapter
        val retrofit= Retrofit.Builder().baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productApi = retrofit.create(IProductsApi::class.java)

        productApi.getListProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: retrofit2.Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {

                response.body()?.run {
                    demos.addAll(this)
                    productsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: retrofit2.Call<List<ProductModel>>, t: Throwable) {
            }

        })

    }
}