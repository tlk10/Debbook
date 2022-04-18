package com.khaled.debbook.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaled.debbook.main.SecondaryActivity
import com.khaled.debbook.main.inflate
import com.khaled.debbook.R
import com.khaled.debbook.model.Faculty
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_item_layout.view.*
import kotlinx.android.synthetic.main.university_list_item_layout.view.*

class UniversityAdapter(public val faculties: MutableList<Faculty>) :
    RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return UniversityAdapter.ViewHolder(parent.inflate(R.layout.university_list_item_layout))
    }

    override fun getItemCount(): Int {
        return faculties.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(faculties[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var faculty: Faculty

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(faculty: Faculty) {
            this.faculty = faculty
            val context = itemView.context
            Glide.with(context)
                .load(faculty.image)
                .into(itemView.facultyImage)
            itemView.facultyName.text = faculty.name

        }

        override fun onClick(view: View) {

            val context = view.context

            var intent = Intent(context, SecondaryActivity::class.java)

            intent.putExtra("FacultyClicked", faculty)
            intent.putExtra("ItemClicked", "2")
            context.startActivity(intent)

        }
    }
}