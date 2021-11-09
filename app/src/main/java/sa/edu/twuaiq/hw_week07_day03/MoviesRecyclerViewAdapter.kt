package sa.edu.twuaiq.hw_week07_day03

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MoviesRecyclerViewAdapter(private val list: List<MoviesModel>) :
    RecyclerView.Adapter<MoviesRecyclerViewAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesRecyclerViewAdapter.MoviesViewHolder {

        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movies_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val item = list[position]
        holder.nameTextView.text = item.name
        holder.realNameTextView.text = "Real Name : ${item.realname}"
        holder.bioTextView.text = item.bio
        holder.createdByTextView.text = "Created by : ${item.createdby}"
        holder.firstAppearanceTextView.text = "First Appearance : ${item.firstappearance}"
        holder.publisherView.text = "publisher : ${item.publisher}"
        holder.teamTextView.text = "Team : ${item.team}"

        // using Picasso (image downloading and caching library)
        Picasso.get().load(item.imageurl).into(holder.imageView);


    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
        val realNameTextView: TextView = itemView.findViewById(R.id.realname_textView)
        val bioTextView: TextView = itemView.findViewById(R.id.bio_textView)
        val createdByTextView: TextView = itemView.findViewById(R.id.createdby_textView)
        val firstAppearanceTextView: TextView = itemView.findViewById(R.id.firstappearance_textView)
        val publisherView: TextView = itemView.findViewById(R.id.publisher_textView)
        val teamTextView: TextView = itemView.findViewById(R.id.team_textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

}