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
import kotlinx.android.synthetic.main.single_transport_list_item.view.*

class SingleTransportAdapter(private val singleTransportCompanies: MutableList<SportPlace>) :
    RecyclerView.Adapter<SingleTransportAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(singleTransportCompanies[position])
    }

    override fun getItemCount(): Int {
        return singleTransportCompanies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleTransportAdapter.ViewHolder {
        return SingleTransportAdapter.ViewHolder(parent.inflate(R.layout.single_transport_list_item))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

        private lateinit var singleTransportCompany: SportPlace
        init {
            itemView.singleTransportWebsite.setOnClickListener(this)
        }

        fun bind(singleTransportCompany: SportPlace) {
            this.singleTransportCompany = singleTransportCompany
            val context = itemView.context
            Glide.with(context)
                .load(singleTransportCompany.placeImage)
                .into(itemView.singleTransportImage)
            itemView.singleTransportCompanyName.text = singleTransportCompany.placeName

        }
        override fun onClick(v: View) {
            openPlace(singleTransportCompany.placeLocation)
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