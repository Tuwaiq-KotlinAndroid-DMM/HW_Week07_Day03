package com.example.marvelrecyclerapiimport

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelrecyclerapi.MoveModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.marvelrecyclerapi.R
import com.squareup.picasso.Picasso

class MarvelRecyclerView(private val list: List<MoveModel>) :
    RecyclerView.Adapter<MarvelRecyclerView.MarvViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelRecyclerView.MarvViewHolder {
        return MarvViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarvViewHolder, position: Int) {
        val item = list[position]
        holder.nametextview.text =item.name
        holder.realnametextview.text = item.realname
        holder.publishertextView.text = item.publisher
        holder.firstAppearance.text= item.firstappearance
        holder.createdbytextView.text = item.createdby

        holder.teamtextview.text = item.team
        holder.biotextview.text = item.bio

        Picasso.get().load(item.imageurl).into(holder.imageUrltextview)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MarvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nametextview : TextView = itemView.findViewById(R.id.name_textView)
        val realnametextview : TextView = itemView.findViewById(R.id.realName_textView)
        val publishertextView : TextView = itemView.findViewById(R.id.publisher_textView)
        val firstAppearance : TextView = itemView.findViewById(R.id.firstAppearance_textView)
        val createdbytextView : TextView = itemView.findViewById(R.id.createdBy_textView)
        val imageUrltextview : ImageView = itemView.findViewById(R.id.imageUrl_textView)
        val  teamtextview : TextView =itemView.findViewById(R.id.team_textView)
        val biotextview : TextView = itemView.findViewById(R.id.bio_textView)

    }
}