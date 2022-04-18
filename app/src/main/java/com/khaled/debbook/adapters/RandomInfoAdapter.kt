package com.khaled.debbook.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.RandomInfo
import kotlinx.android.synthetic.main.random_info_list_item_layout.view.*

class RandomInfoAdapter(private val infos: MutableList<RandomInfo>) :
    RecyclerView.Adapter<RandomInfoAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(infos[position])
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomInfoAdapter.ViewHolder {
        return RandomInfoAdapter.ViewHolder(parent.inflate(R.layout.random_info_list_item_layout))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var info: RandomInfo
        init {
            itemView.infoLink.setOnClickListener(this)
        }

        fun bind(info: RandomInfo) {
            this.info = info
            val context = itemView.context
            Glide.with(context)
                .load(info.image)
                .into(itemView.randominfoImage)
            itemView.infoName.text = info.name
            itemView.infoSummary.text = info.summary

        }
        override fun onClick(v: View) {
            openLink(info.link)

        }
        fun openLink(link: String) {
            val context = itemView.context
            val webIntent: Intent = Uri.parse(link).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            context.startActivity(webIntent)
        }
    }
}