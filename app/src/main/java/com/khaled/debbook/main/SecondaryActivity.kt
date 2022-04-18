package com.khaled.debbook.main

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.debbook.adapters.SingleSportAdapter
import com.khaled.debbook.adapters.SingleTransportAdapter
import com.khaled.debbook.R
import com.khaled.debbook.model.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_dish.*
import kotlinx.android.synthetic.main.activity_dish.summary
import kotlinx.android.synthetic.main.activity_single_faculty.*
import kotlinx.android.synthetic.main.activity_single_holiday.*
import kotlinx.android.synthetic.main.activity_single_land_mark.*
import kotlinx.android.synthetic.main.activity_single_sport.*
import kotlinx.android.synthetic.main.activity_single_transport.*

class SecondaryActivity : AppCompatActivity() {
    private lateinit var bannerSecondary: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = getClickedItem()
        MobileAds.initialize(this, getString(R.string.app_id))
        initialize(id)
    }

    private fun getClickedItem(): String {
        return intent.getStringExtra("ItemClicked") ?: ""
    }

    private fun initialize(id: String) {
        when (id) {
            "1" -> initializeDish()
            "2" -> initializeFaculty()
            "3" -> initializeHoliday()
            "4" -> initializeLandMark()
            "5" -> initializeSport()
            "6" -> initializeTransport()
        }
    }

    private fun initializeDish() {
        val intent = intent
        val food = intent.getParcelableExtra<Food>("FoodClicked") as Food
        setContentView(R.layout.activity_dish)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        supportActionBar?.title = Name.text
        Name.text = food.name
        summary.text = food.summary
        ingredients.text = food.getIngredients()
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        val mBitmapSampled =
            BitmapFactory.decodeResource(this.resources, food.image, options)
        foodImage.setImageBitmap(mBitmapSampled)

        supportActionBar?.title = Name.text
        val placeToEat = findViewById<TextView>(R.id.whereToEat)
        placeToEat.setOnClickListener {
            openPlace(food.places)
        }

        if(food.places.isBlank()) {
            WheretoEatLabel.visibility = GONE
            whereToEat.visibility = GONE
        }

    }

    private fun initializeFaculty() {
        setContentView(R.layout.activity_single_faculty)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        val intent = intent
        val faculty = intent.getParcelableExtra<Faculty>("FacultyClicked") as Faculty
        singleFacultyName.text = faculty.name
        singleFacultySummary.text = faculty.summary
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        val mBitmapSampled =
            BitmapFactory.decodeResource(this.resources, faculty.image, options)
        singleFacultyImage.setImageBitmap(mBitmapSampled)
        val facultyLocation = findViewById<TextView>(R.id.singleFacultyLocation)
        facultyLocation.setOnClickListener {
            openPlace(faculty.location)
        }
        val facultyWebsite = findViewById<TextView>(R.id.singleFacultyWebsite)
        facultyWebsite.setOnClickListener {
            openPlace(faculty.website)
        }
        supportActionBar?.title = singleFacultyName.text
    }

    private fun initializeHoliday() {
        setContentView(R.layout.activity_single_holiday)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        val intent = intent
        val holiday = intent.getParcelableExtra<Holiday>("HolidayClicked") as Holiday

        enName.text = holiday.enname
        summary.text = holiday.summary
        date.text = holiday.date
        hungarianName.text = holiday.huname
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        val mBitmapSampled =
            BitmapFactory.decodeResource(this.resources, holiday.image, options)
        singleHolidayImage.setImageBitmap(mBitmapSampled)
        supportActionBar?.title = enName.text
    }

    private fun initializeLandMark() {
        setContentView(R.layout.activity_single_land_mark)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        val intent = intent
        val landmark = intent.getParcelableExtra<LandMark>("PlaceClicked") as LandMark
        placeName.text = landmark.name
        placeSummary.text = landmark.summary
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        val mBitmapSampled =
            BitmapFactory.decodeResource(this.resources, landmark.image, options)
        placeImage.setImageBitmap(mBitmapSampled)
        val location = findViewById<TextView>(R.id.placeLocation)
        location.setOnClickListener {
            openPlace(landmark.location)
        }

        supportActionBar?.title = placeName.text
    }

    private fun initializeSport() {
        setContentView(R.layout.activity_single_sport)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        val intent = intent
        val sport = intent.getParcelableExtra<Sport>("SportClicked") as Sport
        sportName.text = sport.name + " in Debrecen"
        supportActionBar?.title = sport.name
        singleSportRecyclerView.layoutManager = LinearLayoutManager(this)
        singleSportRecyclerView.adapter = SingleSportAdapter(sport.places)
    }

    private fun initializeTransport() {
        setContentView(R.layout.activity_single_transport)
        val adRequest = AdRequest.Builder().build()
        bannerSecondary = findViewById(R.id.bannerSecondary)
        bannerSecondary.loadAd(adRequest)
        val intent = intent
        val transport = intent.getParcelableExtra<Transport>("TransportClicked") as Transport
        singleTransportName.text = transport.name + " in Debrecen"
        supportActionBar?.title = transport.name
        singleTransportRecyclerView.layoutManager = LinearLayoutManager(this)
        singleTransportRecyclerView.adapter = SingleTransportAdapter(transport.companies)
    }

    private fun openPlace(link: String) {
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(webIntent)
    }
}
