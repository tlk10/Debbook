package com.khaled.debbook.adapters
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Transport
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.transport_list_item_layout.view.*

class TransportAdapter(private val transports: MutableList<Transport>) :
    RecyclerView.Adapter<TransportAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transports[position])
    }

    override fun getItemCount(): Int {
        return transports.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportAdapter.ViewHolder {
        return TransportAdapter.ViewHolder(parent.inflate(R.layout.transport_list_item_layout))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        private lateinit var transport: Transport
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(transport: Transport) {
            this.transport = transport
            val context = itemView.context
            Glide.with(context)
                .load(transport.image)
                .into(itemView.transportImage)
            itemView.transportName.text = transport.name

        }
        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("TransportClicked",transport)
            intent.putExtra("ItemClicked", "6")
            context.startActivity(intent)

        }
    }
}