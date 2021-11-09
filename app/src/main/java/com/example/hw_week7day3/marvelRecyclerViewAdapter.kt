package com.example.hw_week7day3import

import android.graphics.ColorSpace.get
import android.nfc.tech.Ndef.get
import android.nfc.tech.NfcA.get
import android.provider.ContactsContract.ProfileSyncState.get
import android.text.AutoText.get
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_week7day3.MarvelModel
import com.example.hw_week7day3.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.lifecycle.ViewTreeLifecycleOwner.get
import com.google.gson.reflect.TypeToken.get
import com.squareup.picasso.Picasso
import okhttp3.MediaType.get
import okhttp3.internal.platform.Platform.get
import okhttp3.internal.publicsuffix.PublicSuffixDatabase.get
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class marvelRecyclerViewAdapter(private val list: List<MarvelModel>) :
    RecyclerView.Adapter<marvelRecyclerViewAdapter.marvelViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): marvelRecyclerViewAdapter.marvelViewHolder {
        return marvelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.mavel_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: marvelViewHolder, position: Int) {
        val item = list[position]
        Picasso.get().load(item.imageurl).into(holder.marvelImageView)
        holder.marvelTitleTextView.text=item.name
        holder.marvelpublishTextView.text="Publisher: ${item.publisher}"
        holder.marvelrealnameTextView.text="Real name: ${item.realname}"
        holder.marvelteamTextView.text="Team: ${item.team}"
        holder.marvelfirstAppearTextView.text="First appearance: ${item.firstappearance}"
        holder.marvelcreatorTextView.text="Created by: ${item.createdby}"
        holder.marvelbioTextView.text="Bio: ${item.bio}"




    }

    override fun getItemCount(): Int {
        return list.size
    }

    class marvelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val marvelImageView:ImageView=itemView.findViewById(R.id.imageView)
        val marvelTitleTextView:TextView=itemView.findViewById(R.id.marvel_title)
        val marvelpublishTextView:TextView=itemView.findViewById(R.id.marvel_publisher)
        val marvelfirstAppearTextView:TextView=itemView.findViewById(R.id.marvel_firstappear)
        val marvelrealnameTextView:TextView=itemView.findViewById(R.id.marvel_realname)
        val marvelteamTextView:TextView=itemView.findViewById(R.id.marvel_team)
        val marvelcreatorTextView:TextView=itemView.findViewById(R.id.marvel_creartor)
        val marvelbioTextView:TextView=itemView.findViewById(R.id.marvel_bio)

    }
}