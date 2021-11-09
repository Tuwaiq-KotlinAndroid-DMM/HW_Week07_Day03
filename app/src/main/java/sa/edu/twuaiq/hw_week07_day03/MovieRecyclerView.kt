package sa.edu.twuaiq.hw_week07_day03

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MovieRecyclerView(private val list: List<MovieModel>) :
    RecyclerView.Adapter<MovieRecyclerView.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieRecyclerView.MovieViewHolder {

        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int ) {

        val item = list[position]

        holder.nameTextView.text = item.name
        holder.realnameTextView.text = item.realname
        holder.teamTextView.text = item.team
        holder.firstapperanceTextView.text = item.firstappearance
        holder.createdByTextView.text = item.createdby
        holder.publiserTextView.text = item.publisher
        holder.bioTextView.text = item.bio
        Picasso.get().load(item.imageurl).into(holder.imageImageView)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val nameTextView:TextView = itemView.findViewById(R.id.movie_name)
            val realnameTextView:TextView = itemView.findViewById(R.id.movie_realname)
            val teamTextView:TextView = itemView.findViewById(R.id.movie_team)
            val firstapperanceTextView:TextView = itemView.findViewById(R.id.movie_firestapperance)
            val createdByTextView:TextView = itemView.findViewById(R.id.movie_createdBy)
            val publiserTextView:TextView = itemView.findViewById(R.id.movie_publisher)
            val imageImageView:ImageView = itemView.findViewById(R.id.movie_imageView)
            val bioTextView:TextView = itemView.findViewById(R.id.movie_bio)
    }

}