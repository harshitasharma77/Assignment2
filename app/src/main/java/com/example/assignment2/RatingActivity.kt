package com.example.assignment2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class RatingActivity : AppCompatActivity() {

    private lateinit var openDialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        openDialogButton = findViewById(R.id.openDialogButton)

        openDialogButton.setOnClickListener {
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

