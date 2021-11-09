package com.example.jsonarryimport

import androidx.recyclerview.widget.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import sa.edu.twuaiq.hw_week07_day03.ProductModel
import sa.edu.twuaiq.hw_week07_day03.R

class ProductsRecyclerViewAdapter(private val list: List<ProductModel>) :
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
        holder.titleTextView.text = item.name
        holder.descriptionTextView.text = item.bio
        Picasso.get().load(item.imageurl).into(holder.iimageview)
        holder.createdbyTextView.text=item.createdby
        holder.publisherTextView.text=item.publisher
        holder.firstappearanceTextView.text=item.firstappearance
        holder.realnameTextView.text=item.realname
        holder.teamTextView.text=item.team
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.product_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.product_description)
        val iimageview: ImageView = itemView.findViewById(R.id.imageView)
        val realnameTextView:TextView=itemView.findViewById(R.id.textView_realname)
        val teamTextView:TextView=itemView.findViewById(R.id.textView_team)
        val firstappearanceTextView:TextView=itemView.findViewById(R.id.textView_firstappearance)
        val createdbyTextView:TextView=itemView.findViewById(R.id.textView_createdby)
        val publisherTextView:TextView=itemView.findViewById(R.id.textView_publisher)
    }
}