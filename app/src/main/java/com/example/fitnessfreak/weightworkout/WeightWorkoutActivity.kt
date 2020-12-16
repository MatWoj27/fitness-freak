package com.example.fitnessfreak.weightworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessfreak.R
import com.example.fitnessfreak.setDivider
import kotlinx.android.synthetic.main.activity_weight_workout.*

class WeightWorkoutActivity : AppCompatActivity() {
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var viewModel: WeightWorkoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_workout)
        presetToolbar()
        viewModel = ViewModelProvider(this).get(WeightWorkoutViewModel::class.java)
        presetExercisesList()
    }

    private fun presetToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        up_navigation.setOnClickListener { onNavigateUp() }
    }

    private fun presetExercisesList() {
        exerciseAdapter = ExerciseAdapter(mutableListOf())
        exercise_list.apply {
            layoutManager = LinearLayoutManager(this@WeightWorkoutActivity)
            adapter = exerciseAdapter
            setDivider(R.drawable.horizontal_divider)
        }
    }
}
