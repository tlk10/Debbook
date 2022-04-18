package com.khaled.debbook.adapters

import android.media.MediaPlayer
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Phrase
import kotlinx.android.synthetic.main.phrases_list_item_layout.view.*

class PhrasesAdapter(public val phrases: MutableList<Phrase>) :
    RecyclerView.Adapter<PhrasesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return PhrasesAdapter.ViewHolder(parent.inflate(R.layout.phrases_list_item_layout))
    }

    override fun getItemCount(): Int {
        return phrases.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(phrases[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        private lateinit var phrase: Phrase
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(phrase: Phrase) {
            this.phrase = phrase
            itemView.englishWord.text = phrase.english
            itemView.hungarianWord.text = phrase.hungarian
        }
        override fun onClick(v: View) {
            var uri = v.context.resources.getIdentifier(phrase.getAudio,null,v.context.packageName)
            var mediaplayer = MediaPlayer.create(v.context,uri)
            mediaplayer.start()
        }



    }
}