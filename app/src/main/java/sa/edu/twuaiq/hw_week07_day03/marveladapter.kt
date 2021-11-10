package sa.edu.twuaiq.hw_week07_day03import

import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week07_day03.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sa.edu.twuaiq.hw_week07_day03.marveljson

class marveladapter(private val list: List<marveljson>) :
    RecyclerView.Adapter<marveladapter.marvelviewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): marvelviewholder {
        return marvelviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: marvelviewholder, position: Int) {
        val item = list[position]
        holder.nametextview.text=item.name
        holder.biotextview.text=item.bio
        holder.realtextview.text=item.realname
        holder.createdtextview.text=item.createdby
        holder.teamtextview.text=item.team
        holder.publishertextview.text=item.publisher
        holder.firsttextview.text=item.firstappearance
        holder.imagetextview.text=item.imageurl
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class marvelviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nametextview: TextView =itemView.findViewById(R.id.name)
        val realtextview: TextView =itemView.findViewById(R.id.realname)
        val createdtextview: TextView =itemView.findViewById(R.id.createdby)
        val teamtextview: TextView =itemView.findViewById(R.id.team)
        val publishertextview: TextView =itemView.findViewById(R.id.publisher)
        val imagetextview: TextView =itemView.findViewById(R.id.image)
        val firsttextview: TextView =itemView.findViewById(R.id.firstappearance)
        val biotextview: TextView =itemView.findViewById(R.id.bio)

    }
}