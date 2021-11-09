package com.example.marvelmoviesimport

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelmovies.MarvelModel
import com.example.marvelmovies.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MarvelAdapter(private val list: List<MarvelModel>, context: Context) :
    RecyclerView.Adapter<MarvelAdapter.MarvelAViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelAdapter.MarvelAViewHolder {
        return MarvelAViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarvelAViewHolder, position: Int) {
        val item = list[position]

        holder.nameTextView.text = item.name
        holder.realnameTextView.text = "Real name: ${item.realname}"
        holder.teamTextView.text = "Team: ${item.team}"
        holder.firstappearanceTextView.text = "First Appearance: ${item.firstappearance}"
        holder.createdbyTextView.text = "Created By: ${item.createdby}"
        holder.publisherTextView.text = "Publisher: ${item.publisher}"
        holder.bioTextView.text ="bio: ${item.bio}"

        // I use Picasso library to load images
        Picasso.get().load(item.imageurl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MarvelAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView = itemView.findViewById(R.id.nameTextview)
        val realnameTextView: TextView = itemView.findViewById(R.id.realnameTextview)
        val teamTextView: TextView = itemView.findViewById(R.id.teamTextview)
        val firstappearanceTextView: TextView = itemView.findViewById(R.id.firstapperanceTextview)
        val createdbyTextView: TextView = itemView.findViewById(R.id.createdbyTextview)
        val publisherTextView: TextView = itemView.findViewById(R.id.publisherTextview)
        val imageView: ImageView = itemView.findViewById(R.id.marvel_imageView)
        val bioTextView:TextView = itemView.findViewById(R.id.bioTextview)
    }
}