package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.LandMark
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.landmark_list_item.view.*

class LandMarksAdapter (public val places: MutableList<LandMark>) :
    RecyclerView.Adapter<LandMarksAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LandMarksAdapter.ViewHolder(parent.inflate(R.layout.landmark_list_item))
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(places[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var place: LandMark
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(place: LandMark) {
            this.place = place
            val context = itemView.context
            Glide.with(context)
                .load(place.image)
                .into(itemView.placeImage)
            itemView.placeName.text = place.name

        }

        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("PlaceClicked",place)
            intent.putExtra("ItemClicked", "4")
            context.startActivity(intent)

        }
    }
}