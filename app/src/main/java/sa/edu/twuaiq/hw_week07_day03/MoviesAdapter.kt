package sa.edu.twuaiq.hw_week07_day03import

import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.MoviesModel
import sa.edu.twuaiq.hw_week07_day03.R


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class MoviesAdapter(private val list: List<MoviesModel>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movies_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.nameTextView.text = "Name: ${item.name}"
        holder.bioTextView.text = "Bio: ${item.bio}"
        Picasso.get().load(item.imageurl).into(holder.imageView)
        holder.realnameTextView.text = "Real name: ${item.realname}"
        holder.teamTextView.text = "team: ${item.team}"
        holder.firstappearanceTextView.text = "First appearance: ${item.firstappearance}"
        holder.createdbyTextView.text = "Created by :${item.createdby}"
        holder.publisherTextView.text = "Publisher by: ${item.publisher}"

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView : TextView = itemView.findViewById(R.id.name_movie_txtview)
        val bioTextView : TextView = itemView.findViewById(R.id.bio_movies_textview)
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val realnameTextView :TextView = itemView.findViewById(R.id.realname_movie_textView)
        val teamTextView : TextView = itemView.findViewById(R.id.team_movie_textView)
        val firstappearanceTextView :TextView = itemView.findViewById(R.id.firstappearance_movie_textView)
        val createdbyTextView : TextView = itemView.findViewById(R.id.createdby_movie_textView)
        val publisherTextView :TextView = itemView.findViewById(R.id.publisher_movie_textView)


    }
}