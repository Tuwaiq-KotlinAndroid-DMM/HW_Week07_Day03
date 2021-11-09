package sa.edu.twuaiq.hw_week07_day03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MoviesRecyclerAdapter(private val list: List<Movies>): RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesRecyclerAdapter.MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = list[position]
        holder.name_textView.text = item.name
        holder.realname_textView.text = item.realname
        holder.team_textView.text = item.team
        holder.firstappearance_textView.text = item.firstappearance
        holder.createdby_textView.text = item.createdby
        holder.publisher_textView.text = item.publisher
        Picasso.get().load(item.imageurl).into(holder.imageur_imageView)
        holder.bio_textView.text = item.bio

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_textView  : TextView = itemView.findViewById(R.id.name_textView)
        val realname_textView : TextView = itemView.findViewById(R.id.realname_textView)
        val team_textView : TextView = itemView.findViewById(R.id.team_textView)
        val firstappearance_textView: TextView = itemView.findViewById(R.id.firstappearance_textView)
        val createdby_textView: TextView = itemView.findViewById(R.id.createdby_textView)
        val publisher_textView: TextView = itemView.findViewById(R.id.publisher_textView)
        val imageur_imageView: ImageView = itemView.findViewById(R.id.imageur_imageView)
        val bio_textView: TextView = itemView.findViewById(R.id.bio_textView)

    }
}