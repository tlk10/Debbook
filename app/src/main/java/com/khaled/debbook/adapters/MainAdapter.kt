package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.PrimaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.MainItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.main_list_item_layout.view.*

class MainAdapter(private val mainItems: MutableList<MainItem>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.main_list_item_layout))
    }

    override fun getItemCount(): Int {
        return mainItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mainItems[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var item: MainItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: MainItem) {
            this.item = item
            val context = itemView.context
            Glide.with(context)
                .load(item.image)
                .into(itemView.main_item_image)
            itemView.main_item_name.text = item.name
            itemView.idd.text = item.id.toString()
            itemView.main_item_description.text = item.description

        }

        override fun onClick(view: View) {
            val context = view.context
            var intent = Intent(context, PrimaryActivity::class.java)

            intent.putExtra("ItemClicked", item.id.toString())
            context.startActivity(intent)

        }
    }
}