package com.khaled.debbook.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.debbook.adapters.MainAdapter
import com.khaled.debbook.R
import com.khaled.debbook.model.MainItem
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bannerMainUp: AdView
    private lateinit var bannerMainDown: AdView

    private var mainItems: ArrayList<MainItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, getString(R.string.app_id))
        bannerMainUp = findViewById(R.id.bannerMainUp)
        bannerMainDown = findViewById(R.id.bannerMainDown)
        val adRequest = AdRequest.Builder().build()
        bannerMainUp.loadAd(adRequest)
        bannerMainDown.loadAd(adRequest)
        addItems()
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = MainAdapter(mainItems)

    }

    private fun addItems() {
        mainItems.add(
            MainItem(
                1,
                "Food",
                R.drawable.food,
                "All you need to know about food."
            )
        )
        mainItems.add(
            MainItem(
                2,
                "Official Documents",
                R.drawable.documents,
                "Your guide in getting all the important student documents."
            )
        )
        mainItems.add(
            MainItem(
                3,
                "Jobs",
                R.drawable.jobs,
                "Looking for a job? We will help you find the best."
            )
        )
        mainItems.add(
            MainItem(
                4,
                "Landmarks",
                R.drawable.landmarks,
                "Start exploring the beautiful Debrecen!"
            )
        )
        mainItems.add(
            MainItem(
                5,
                "Transportation",
                R.drawable.transport,
                "Find out everything about the transportation system in Debrecen and Hungary."
            )
        )
        mainItems.add(
            MainItem(
                6,
                "Sports",
                R.drawable.sports,
                "The most popular locations for sports in Debrecen, including gyms and spas."
            )
        )
        mainItems.add(
            MainItem(
                7,
                "National Holidays",
                R.drawable.nationalholidays,
                "It's holiday and you don't know what to do? We will help you figure it out!"
            )
        )
        mainItems.add(
            MainItem(
                8,
                "The University",
                R.drawable.university,
                "Where to find all the info you need regarding the faculties in Debrecen."
            )
        )
        mainItems.add(
            MainItem(
                9,
                "Hungarian phrases",
                R.drawable.phrases,
                "Some Hungarian words and phrases you need in your daily Hungarian life."
            )
        )
        mainItems.add(
            MainItem(
                10,
                "Random Info",
                R.drawable.randominfo,
                "Some random info you might find useful."
            )
        )
        mainItems.add(
            MainItem(
                11,
                "Ask Us!",
                R.drawable.askus,
                "Didn't find what you are looking for? It's ok, just contact us!"
            )
        )


    }
}
