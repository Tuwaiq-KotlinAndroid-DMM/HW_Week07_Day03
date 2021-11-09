package sa.edu.twuaiq.hw_week07_day03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso

class movieDetailsFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }
    /*
    * name = item.name
                bio = item.bio
                createdBy = item.createdby
                firstAppearance = item.firstappearance
                imageUrl = item.imageurl
                publisher = item.publisher
                realName = item.realname
                team = item.team*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title: TextView = view.findViewById(R.id.details_movie_tiltle)
        val bioTextView: TextView = view.findViewById(R.id.details_bio)
        val createdByTextView: TextView = view.findViewById(R.id.details_createdby)
        val firstAppearanceTextView: TextView = view.findViewById(R.id.details_movie_firstappearance)
        val poster: ImageView = view.findViewById(R.id.details_movie_image)
        val publisherTextView: TextView = view.findViewById(R.id.details_publisher)
        val realNameTextView: TextView = view.findViewById(R.id.details_movie_realname)
        val teamTextView: TextView = view.findViewById(R.id.details_movie_team)

        // Setting the values from the view model!
        movieViewModel.apply {
            title.text = name
            bioTextView.text = bio
            createdByTextView.text = "Created by: $createdBy"
            firstAppearanceTextView.text = firstAppearance
            Picasso.get().load(imageUrl).into(poster)
            publisherTextView.text = "Publisher: $publisher"
            teamTextView.text = "The team: $team"
            realNameTextView.text = "Real name: $realName"
        }
    }
}