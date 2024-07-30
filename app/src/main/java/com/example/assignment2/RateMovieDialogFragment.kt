package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class RateMovieDialogFragment : DialogFragment() {

    private lateinit var ratingEditText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var submitRatingButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rate_movie, container, false)

        ratingEditText = view.findViewById(R.id.ratingEditText)
        radioGroup = view.findViewById(R.id.radioGroup1)
        submitRatingButton = view.findViewById(R.id.submitRatingButton)

        submitRatingButton.setOnClickListener {
            val ratingText = ratingEditText.text.toString()
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRating = when (selectedRadioButtonId) {
                R.id.radio1 -> "1 Star"
                R.id.radio2 -> "2 Stars"
                R.id.radio3 -> "3 Stars"
                R.id.radio4 -> "4 Stars"
                R.id.radio5 -> "5 Stars"
                else -> ""
            }

            if (ratingText.isNotEmpty() && selectedRating.isNotEmpty()) {
                Toast.makeText(requireContext(), "Rating: $ratingText, $selectedRating", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(requireContext(), "Please enter a rating and select a star rating", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
