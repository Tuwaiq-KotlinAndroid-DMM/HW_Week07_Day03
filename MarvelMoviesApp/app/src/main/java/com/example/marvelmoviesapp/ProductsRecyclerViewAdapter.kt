package com.example.marvelmoviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsRecyclerViewAdapter(private val list: List<ProductModelItem>) :
    RecyclerView.Adapter<ProductsRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsRecyclerViewAdapter.ProductViewHolder {

        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = list[position]

        holder.productName.text = item.name
        holder.productRealName.text = item.realname
        holder.productFirstAppearance.text = item.firstappearance
        holder.productCreatedBy.text = item.createdby
        holder.productPublisher.text = item.publisher
        holder.productBio.text = item.bio
        holder.productTeam.text = item.team





    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productRealName: TextView = itemView.findViewById(R.id.product_real_name)
        val productFirstAppearance: TextView = itemView.findViewById(R.id.product_first_appearance)
        val productCreatedBy: TextView = itemView.findViewById(R.id.product_created_by)
        val productPublisher: TextView = itemView.findViewById(R.id.product_publisher)
        val productBio: TextView = itemView.findViewById(R.id.product_bio)
        val productTeam: TextView = itemView.findViewById(R.id.product_team)
        val productImageView: ImageView = itemView.findViewById(R.id.imageView)
    }

}