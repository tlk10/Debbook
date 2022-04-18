package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Holiday
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*


import kotlinx.android.synthetic.main.holidays_list_item_layout.view.*

class HolidayAdapter(public val holidays: MutableList<Holiday>) :
    RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return HolidayAdapter.ViewHolder(parent.inflate(R.layout.holidays_list_item_layout))
    }

    override fun getItemCount(): Int {
        return holidays.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(holidays[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var holiday: Holiday

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(holiday: Holiday) {
            this.holiday = holiday
            val context = itemView.context
            Glide.with(context)
                .load(holiday.image)
                .into(itemView.holidayImage)
            itemView.holidayName.text = holiday.enname

        }

        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("HolidayClicked", holiday)
            intent.putExtra("ItemClicked", "3")
            context.startActivity(intent)

        }
    }
}