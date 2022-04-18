package com.khaled.debbook.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Document
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.documents_list_item_layout.view.*
import kotlinx.android.synthetic.main.food_list_item_layout.view.*

class DocumentsAdapter (private val documents: MutableList<Document>) :
    RecyclerView.Adapter<DocumentsAdapter.ViewHolder>() {





    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(documents[position])
    }

    override fun getItemCount(): Int {
        return documents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentsAdapter.ViewHolder {
        return DocumentsAdapter.ViewHolder(parent.inflate(R.layout.documents_list_item_layout))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        private lateinit var document: Document
        init {
            itemView.documentInfo.setOnClickListener(this)
            itemView.documentLocation.setOnClickListener(this)
        }

        fun bind(document: Document) {
            this.document = document
            val context = itemView.context
            Glide.with(context)
                .load(document.image)
                .into(itemView.documentImage)
            itemView.documentName.text = document.name
        }

        override fun onClick(v: View) {

            if(v.id == R.id.documentInfo){
                openPlace(document.info)
            }
            else if (v.id == R.id.documentLocation){
                openPlace(document.location)
            }
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