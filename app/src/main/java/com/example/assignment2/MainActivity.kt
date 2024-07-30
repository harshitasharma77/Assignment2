package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var movieSpinner: Spinner
    private lateinit var rateMovieButton: Button
    private lateinit var viewDetailsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        movieSpinner = findViewById(R.id.movieSpinner)
        rateMovieButton = findViewById(R.id.rateMovieButton)
        viewDetailsButton = findViewById(R.id.viewDetailsButton)

        val movies = arrayOf("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        movieSpinner.adapter = adapter

        rateMovieButton.setOnClickListener {
            val selectedMovie = movieSpinner.selectedItem.toString()
            val intent = Intent(this, RatingActivity::class.java)
            intent.putExtra("selectedMovie", selectedMovie)
            startActivity(intent)
        }

        viewDetailsButton.setOnClickListener {
            val selectedMovie = movieSpinner.selectedItem.toString()
            val movieDescription = "Description of $selectedMovie" // Replace with actual movie details

            val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                putExtra("movieTitle", selectedMovie)
                putExtra("movieDescription", movieDescription)
            }
            startActivity(intent)
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
