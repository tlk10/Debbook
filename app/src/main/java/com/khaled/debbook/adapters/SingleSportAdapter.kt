package com.khaled.debbook.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.SportPlace
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.single_sport_list_item.view.*

class SingleSportAdapter(private val singleSportPlaces: MutableList<SportPlace>) :
    RecyclerView.Adapter<SingleSportAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(singleSportPlaces[position])
    }

    override fun getItemCount(): Int {
        return singleSportPlaces.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleSportAdapter.ViewHolder {
        return SingleSportAdapter.ViewHolder(parent.inflate(R.layout.single_sport_list_item))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

        private lateinit var singleSportPlace: SportPlace
        init {
            itemView.singleSportPlaceAddress.setOnClickListener(this)
        }

        fun bind(singleSportPlace: SportPlace) {
            this.singleSportPlace = singleSportPlace
            val context = itemView.context
            Glide.with(context)
                .load(singleSportPlace.placeImage)
                .into(itemView.singleSportImage)
            itemView.singleSportPlaceName.text = singleSportPlace.placeName

        }
        override fun onClick(v: View) {
            openPlace(singleSportPlace.placeLocation)
        }
        fun openPlace(link: String) {
            val context = itemView.context
            val webIntent: Intent = Uri.parse(link).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            context.startActivity(webIntent)
        }

    }
}