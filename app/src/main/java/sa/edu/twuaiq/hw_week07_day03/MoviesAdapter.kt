package sa.edu.twuaiq.hw_week07_day03import

import android.provider.Contacts
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
    RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesHolder {
        return MoviesHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val item = list[position]
        holder.nameText.text = item.name
        holder.realNameText.text = item.realname
        holder.appearanceText.text = item.firstappearance
        holder.teamText.text = item.team
        holder.createdText.text = item.createdby
        holder.publishedText.text = item.publisher
        holder.bioText.text = item.bio

        Picasso.get().load(item.imageurl).into(holder.image)
    }



    override fun getItemCount(): Int {
        return list.size
    }

    class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val realNameText: TextView = itemView.findViewById(R.id.realname_text)
        val teamText: TextView = itemView.findViewById(R.id.team_text)
        val appearanceText: TextView = itemView.findViewById(R.id.appearance_text)
        val publishedText: TextView = itemView.findViewById(R.id.publisher_text)
        val createdText: TextView = itemView.findViewById(R.id.created_text)
        val bioText: TextView = itemView.findViewById(R.id.bio_text)
        val image: ImageView = itemView.findViewById(R.id.imageView4)
    }
}