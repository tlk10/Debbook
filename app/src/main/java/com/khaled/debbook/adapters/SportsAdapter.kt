package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Sport
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.sport_list_item_layout.view.*

class SportsAdapter(public val sports: MutableList<Sport>) :
    RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return SportsAdapter.ViewHolder(parent.inflate(R.layout.sport_list_item_layout))
    }

    override fun getItemCount(): Int {
        return sports.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sports[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var sport: Sport
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(sport: Sport) {
            this.sport = sport
            val context = itemView.context
            Glide.with(context)
                .load(sport.image)
                .into(itemView.sportImage)
            itemView.sportName.text = sport.name

        }

        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("SportClicked",sport)
            intent.putExtra("ItemClicked", "5")
            context.startActivity(intent)

        }
    }
}