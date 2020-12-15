package com.example.fitnessfreak.weightworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.fitnessfreak.R
import kotlinx.android.synthetic.main.activity_weight_workout.*

class WeightWorkoutActivity : AppCompatActivity() {
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var viewModel: WeightWorkoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_workout)
        presetToolbar()
        viewModel = ViewModelProvider(this).get(WeightWorkoutViewModel::class.java)
    }

    private fun presetToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        up_navigation.setOnClickListener { onNavigateUp() }
    }
}
