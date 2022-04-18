package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Food
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_dish.view.*


import kotlinx.android.synthetic.main.food_list_item_layout.view.*

class FoodAdapter(public val foods: MutableList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return FoodAdapter.ViewHolder(parent.inflate(R.layout.food_list_item_layout))
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foods[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var food: Food
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(food: Food) {
            this.food = food
            val context = itemView.context
            Glide.with(context)
                .load(food.image)
                .into(itemView.dishImage)
            itemView.dishName.text = food.name

        }

        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("FoodClicked",food)
            intent.putExtra("ItemClicked", "1")
            context.startActivity(intent)

        }
    }
}