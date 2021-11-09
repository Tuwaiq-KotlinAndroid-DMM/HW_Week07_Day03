package sa.edu.twuaiq.hw_week07_day03

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

class RecyclerViewMovieAdapter(private val list: List<MovieModel>) :
    RecyclerView.Adapter<RecyclerViewMovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewMovieAdapter.MovieViewHolder {

        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {




        val item = list[position]
        holder.nameTextView.text = item.name
        holder.realnameTextView .text = item.realname
        holder.teamTextView .text = item.team
        holder.firstappearanceTextView .text = item.firstappearance
        holder.createdbyTextView .text = item.createdby
        holder.publisherTextView.text = item.publisher
        holder.bioTextView.text = item.bio
        Picasso.get().load(item.imageurl).into(holder.imageurlView)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView:TextView = itemView.findViewById(R.id.nameTextView)
        val realnameTextView:TextView = itemView.findViewById(R.id.realNameTextView)
        val teamTextView:TextView = itemView.findViewById(R.id.teamTextView)
        val firstappearanceTextView:TextView = itemView.findViewById(R.id.firstappearanceTextView)
        val createdbyTextView:TextView = itemView.findViewById(R.id.createdbyTextView)
        val publisherTextView:TextView = itemView.findViewById(R.id.publisherTextView)
        val imageurlView:ImageView = itemView.findViewById(R.id.MovieImageView)
        val bioTextView:TextView = itemView.findViewById(R.id.bioTextView)



    }

}