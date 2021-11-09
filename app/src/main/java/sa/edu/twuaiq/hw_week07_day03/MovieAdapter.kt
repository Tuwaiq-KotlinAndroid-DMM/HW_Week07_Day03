package sa.edu.twuaiq.hw_week07_day03import

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.MovieModel
import sa.edu.twuaiq.hw_week07_day03.R
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import java.net.URL


class MovieAdapter(private val list: List<MovieModel>, val context: Context) :
    RecyclerView.Adapter<MovieAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = list[position]

        holder.nameTextView.text = item.name
        holder.realnameTextView.text = "Real Name: ${item.realname}"
        holder.teamTextView.text = "Team: ${item.team}"
        holder.firstappearanceTextView.text = "First Appearance: ${item.firstappearance}"
        holder.createdbyTextView.text = "CreatedBy: ${item.createdby}"
        holder.publisherTextView.text = "Publisher: ${item.publisher}"
        holder.bioTextView.text = item.bio
        Picasso.get().load(item.imageurl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_textview)
        val realnameTextView: TextView = itemView.findViewById(R.id.realname_textview)
        val teamTextView: TextView = itemView.findViewById(R.id.team_textview)
        val firstappearanceTextView: TextView = itemView.findViewById(R.id.firstapperance_textview)
        val createdbyTextView: TextView = itemView.findViewById(R.id.createdby_textview)
        val publisherTextView: TextView = itemView.findViewById(R.id.publisher_textview)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val bioTextView: TextView = itemView.findViewById(R.id.bio_textview)

    }
}