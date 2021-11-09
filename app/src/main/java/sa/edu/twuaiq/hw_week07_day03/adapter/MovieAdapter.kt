package sa.edu.twuaiq.hw_week07_day03.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import sa.edu.twuaiq.hw_week07_day03.MovieViewModel
import sa.edu.twuaiq.hw_week07_day03.R
import sa.edu.twuaiq.hw_week07_day03.model.MovieModel

class MovieAdapter(private val list: List<MovieModel>, private val movieViewModel: MovieViewModel) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            titleTextView.text = item.name
            firstAppearanceTextView.text = item.firstappearance
            Picasso.get().load(item.imageurl).into(posterImageView)
        }
        holder.itemView.setOnClickListener {
            movieViewModel.apply {
                name = item.name
                bio = item.bio
                createdBy = item.createdby
                firstAppearance = item.firstappearance
                imageUrl = item.imageurl
                publisher = item.publisher
                realName = item.realname
                team = item.team
            }
            it.findNavController().navigate(R.id.action_movieListFragment_to_movieDetailsFragment)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        val firstAppearanceTextView: TextView = itemView.findViewById(R.id.movie_first_appearance)
        val posterImageView: ImageView = itemView.findViewById(R.id.movie_image)
    }
}