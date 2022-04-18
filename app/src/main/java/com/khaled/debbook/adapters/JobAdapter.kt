package com.khaled.debbook.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Job
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.job_list_item_layout.view.*

class JobAdapter(private val jobs: MutableList<Job>) :
    RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jobs[position])
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.ViewHolder {
        return JobAdapter.ViewHolder(parent.inflate(R.layout.job_list_item_layout))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var job: Job


        fun bind(job: Job) {
            this.job = job
            val context = itemView.context
            Glide.with(context)
                .load(job.image)
                .into(itemView.jobImage)
            itemView.jobName.text = job.name
            itemView.jobAddress.text = job.address
            itemView.jobPhone.text = job.phone
            itemView.JobWebsite.text = job.website

        }
    }
}