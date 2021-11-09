package sa.edu.twuaiq.hw_week07_day03import

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.MovieDataModel
import sa.edu.twuaiq.hw_week07_day03.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MovieRcyclerAdapter(private val list: List<MovieDataModel>) :
    RecyclerView.Adapter<MovieRcyclerAdapter.MovieViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieRcyclerAdapter.MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            nameTextView.text = item.name
            realNameTextView.text = item.realname
            teamTextView.text = item.team
            firstAppearanceTextView.text = item.firstappearance
            createdByTextView.text = item.createdby
            publisherTextView.text = item.publisher
            bioTextView.text = item.bio

        }
       Picasso.get()
           .load(item.imageurl)
           .into(holder.movieImageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
        val realNameTextView: TextView = itemView.findViewById(R.id.realname_textView)
        val teamTextView: TextView = itemView.findViewById(R.id.team_textView)
        val firstAppearanceTextView: TextView = itemView.findViewById(R.id.firstappearance_textView)
        val createdByTextView: TextView = itemView.findViewById(R.id.created_textView)
        val publisherTextView: TextView = itemView.findViewById(R.id.publisher_textView)
        val bioTextView: TextView = itemView.findViewById(R.id.bio_textView)

        val movieImageView: ImageView = itemView.findViewById(R.id.movie_imageView)

    }
}