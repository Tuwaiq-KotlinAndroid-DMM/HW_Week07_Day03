package sa.edu.twuaiq.hw_week07_day03import

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.MarvelModel
import sa.edu.twuaiq.hw_week07_day03.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso


class MarvelRecyclerViewAdapter(private val list: List<MarvelModel>) :
    RecyclerView.Adapter<MarvelRecyclerViewAdapter.MarvelViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelRecyclerViewAdapter.MarvelViewHolder {
        return MarvelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.marvel_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        val item = list[position]
        holder.nameTextView.text = item.name
        holder.realnameTextView.text = item.realname
        holder.teamTextView.text = item.team
        holder.firstappearanceTextView.text = item.firstappearance
        holder.createdbyTextView.text = item.createdby
        holder.publisherTextView.text = item.publisher
        holder.bioTextView.text = item.bio
        Picasso.get().load(item.imageurl).into((holder.imageView))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MarvelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_textview)
        val realnameTextView: TextView = itemView.findViewById(R.id.realname_textview)
        val teamTextView: TextView = itemView.findViewById(R.id.team_textview)
        val firstappearanceTextView: TextView = itemView.findViewById(R.id.firstappearance_textview)
        val createdbyTextView: TextView = itemView.findViewById(R.id.createdby_textview)
        val publisherTextView: TextView = itemView.findViewById(R.id.publisher_textview)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val bioTextView: TextView = itemView.findViewById(R.id.bio_textview)

    }
}