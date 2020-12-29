package com.example.fitnessfreak.weightworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessfreak.R
import com.example.fitnessfreak.common.setDivider
import com.example.fitnessfreak.weightworkout.models.WeightExercise
import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import kotlinx.android.synthetic.main.activity_weight_workout.*

class WeightWorkoutActivity : AppCompatActivity() {
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var viewModel: WeightWorkoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_workout)
        presetToolbar()
        viewModel = ViewModelProvider(this).get(WeightWorkoutViewModel::class.java)
        viewModel.getWeightWorkoutLiveData().observe(this, Observer { loadWorkout(it) })
        viewModel.getDisplayDateLiveData().observe(this, Observer { date.text = it })
    }

    private fun presetToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        up_navigation.setOnClickListener { onNavigateUp() }
    }

    private fun loadWorkout(weightWorkout: WeightWorkout) {
        workout_name.text = weightWorkout.name
        presetExercisesList(weightWorkout.exercises)
    }

    private fun presetExercisesList(exercises: List<WeightExercise>) {
        exerciseAdapter = ExerciseAdapter(exercises.toMutableList())
        exercise_list.apply {
            layoutManager = LinearLayoutManager(this@WeightWorkoutActivity)
            adapter = exerciseAdapter
            setDivider(R.drawable.horizontal_divider)
        }
    }
}
