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

class MovieAdapter(private val list: List<MoviesModel>) :
    RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = list[position]
        Picasso.get().load(item.imageurl).into(holder.image1)
        holder.name1.text = item.name
        holder.realname1.text = "Real name: ${item.realname}"
        holder.team1.text = "team: ${item.team}"
        holder.firstappearance1.text = "First appearance: ${item.firstappearance}"
        holder.createdby1.text = "Created by :${item.createdby}"
        holder.publisher1.text = "Publisher by: ${item.publisher}"
        holder.bio1.text = "Bio: ${item.bio}"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name1:TextView = itemView.findViewById(R.id.textView)
        val realname1:TextView = itemView.findViewById(R.id.textView2)
        val team1:TextView = itemView.findViewById(R.id.textView3)
        val firstappearance1:TextView = itemView.findViewById(R.id.textView4)
        val createdby1:TextView = itemView.findViewById(R.id.textView5)
        val publisher1:TextView = itemView.findViewById(R.id.textView6)
        val image1:ImageView = itemView.findViewById(R.id.imageView)
        val bio1:TextView = itemView.findViewById(R.id.textView7)

    }
}