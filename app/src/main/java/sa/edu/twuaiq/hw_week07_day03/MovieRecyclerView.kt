package sa.edu.twuaiq.hw_week07_day03

import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.MovieName
import sa.edu.twuaiq.hw_week07_day03.R


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class MovieRecyclerView(private val list: List<MovieName>) :
    RecyclerView.Adapter<MovieRecyclerView.MovieViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieRecyclerView.MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movies_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = list[position]
        holder.nameTextView.text = item.name
        holder.realnameTextView.text = item.realname
        holder. teamTextView.text = item.team
        holder.firstTapAppranceTextView.text = item.firstappearance
        holder.createdbyTextView.text = item.createdby
        holder.publisherTextView.text = item.publisher
        holder.bioTextView.text = item.bio
        Picasso.get().load(item.imageurl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_movie)
        val realnameTextView: TextView = itemView.findViewById(R.id.realname_movie)
        val teamTextView: TextView = itemView.findViewById(R.id.team_movie)
        val firstTapAppranceTextView: TextView = itemView.findViewById(R.id.firsttapappearnce_movie)
        val createdbyTextView: TextView = itemView.findViewById(R.id.createdBy_movie)
        val publisherTextView: TextView = itemView.findViewById(R.id.publisher_movie)
        val bioTextView: TextView = itemView.findViewById(R.id.bio_movie)
        val imageView: ImageView = itemView.findViewById(R.id.image_movie)

    }
}