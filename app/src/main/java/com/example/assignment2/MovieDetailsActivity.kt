package com.example.assignment2


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var movieTitleTextView: TextView
    private lateinit var moviePosterImageView: ImageView
    private lateinit var movieDescriptionTextView: TextView
    private lateinit var rateNowButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        movieTitleTextView = findViewById(R.id.movieTitleTextView)
        movieDescriptionTextView = findViewById(R.id.movieDescriptionTextView)
        rateNowButton = findViewById(R.id.rateNowButton)
        val movieTitle = intent.getStringExtra("movieTitle") ?: "Unknown"
        val movieDescription = intent.getStringExtra("movieDescription") ?: "No description available"


        movieTitleTextView.text = movieTitle
        movieDescriptionTextView.text = movieDescription

        rateNowButton.setOnClickListener {
            val rateMovieDialog = RateMovieDialogFragment()
            rateMovieDialog.show(supportFragmentManager, "RateMovieDialogFragment")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle settings action
                true
            }
            R.id.action_about -> {
                // Handle about action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
