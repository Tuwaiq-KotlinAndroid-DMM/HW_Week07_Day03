package sa.edu.twuaiq.hw_week07_day03

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MarvelAdapter(private val list: List<MarvelModel>) :
    RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelAdapter.MarvelViewHolder {

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
        // to show the pic >> Picasso >> library
        Picasso.get().load(item.imageurl).into((holder.imageview))
        holder.bio1.text= item.bio
        holder.creatby1.text= item.createdby
        holder.firstappearance1.text= item.firstappearance
        holder.name1.text= item.name
        holder.publisher1.text= item.publisher
        holder.realname1.text= item.realname
        holder.team1.text= item.team
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MarvelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val imageview : ImageView = itemView.findViewById(R.id.imageView)
        val bio1 : TextView = itemView.findViewById(R.id.bio_textView)
        val creatby1 : TextView = itemView.findViewById(R.id.creatby_TextView)
        val firstappearance1 : TextView = itemView.findViewById(R.id.firstappearance_TextView)
        val name1 : TextView = itemView.findViewById(R.id.name_TextView)
        val publisher1 : TextView = itemView.findViewById(R.id.publisher_TextView)
        val realname1 : TextView = itemView.findViewById(R.id.realname_TextView)
        val team1 : TextView = itemView.findViewById(R.id.team_TextView)


    }

}
