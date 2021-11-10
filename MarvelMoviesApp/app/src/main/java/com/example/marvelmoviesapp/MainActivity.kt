package com.example.marvelmoviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val products = mutableListOf<ProductModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productRecyclerView: RecyclerView = findViewById(R.id.product_recyclerview)
        val productsAdapter = ProductsRecyclerViewAdapter(products)

        productRecyclerView.adapter = productsAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productApi = retrofit.create(IProductsApi::class.java)
        productApi.getListProducts().enqueue(object : Callback<List<ProductModelItem>> {
            override fun onResponse(
                call: Call<List<ProductModelItem>>,
                response: Response<List<ProductModelItem>>
            ) {


                response.body()?.run {
                    products.addAll(this)
                    productsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<ProductModelItem>>, t: Throwable) {
            }

        })


    }
}