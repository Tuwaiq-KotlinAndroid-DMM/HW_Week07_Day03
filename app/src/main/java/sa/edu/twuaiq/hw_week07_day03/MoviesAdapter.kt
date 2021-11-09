package sa.edu.twuaiq.hw_week07_day03

import android.content.Context
import android.graphics.ColorSpace.get
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class MoviesAdapter(private val list: List<MoviesModel>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//getting the item_layout views
        val nameTv: TextView = itemView.findViewById(R.id.tv_movie_name)
        val realNameTv: TextView = itemView.findViewById(R.id.tv_movie_realname)
        val teamTv: TextView = itemView.findViewById(R.id.tv_movie_team)
        val firstAppearanceTv: TextView = itemView.findViewById(R.id.tv_movie_firstAppearance)
        val createdByTv: TextView = itemView.findViewById(R.id.tv_movie_createdby)
        val publishedTv:TextView = itemView.findViewById(R.id.tv_movie_published)
        val moviesImage: ImageView = itemView.findViewById(R.id.movie_imageView)
        val bioTv: TextView = itemView.findViewById(R.id.tv_movie_bio)



    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MoviesAdapter.MoviesViewHolder {
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
// assigning the data
        holder.nameTv.text = item.name
        holder.realNameTv.text = item.name
        holder.teamTv.text = item.team
        holder.firstAppearanceTv.text = item.firstappearance
        holder.createdByTv.text = item.createdby
        holder.publishedTv.text = item.publisher
        holder.bioTv.text = item.bio
 // attaching the image using picasso
        Picasso.get().load(item.imageurl).into(holder.moviesImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }


}