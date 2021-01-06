package com.example.fitnessfreak.weightworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessfreak.R
import com.example.fitnessfreak.common.setDivider
import com.example.fitnessfreak.common.setTextWithAnimation
import com.example.fitnessfreak.weightworkout.models.WeightExercise
import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import kotlinx.android.synthetic.main.activity_weight_workout.*
import kotlinx.android.synthetic.main.weight_workout_toolbar.*

class WeightWorkoutActivity : AppCompatActivity() {
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var viewModel: WeightWorkoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_workout)
        presetToolbar()
        initViewModel()
        previous_date.setOnClickListener { viewModel.previousDate() }
        next_date.setOnClickListener { viewModel.nextDate() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(WeightWorkoutViewModel::class.java).apply {
            getWeightWorkoutLiveData().observe(
                this@WeightWorkoutActivity,
                Observer { loadWorkout(it) })
            getDisplayDateLiveData().observe(
                this@WeightWorkoutActivity,
                Observer {
                    date.setTextWithAnimation(
                        it.first,
                        it.second
                    )
                })
        }
    }

    private fun presetToolbar() {
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        up_navigation.setOnClickListener { onNavigateUp() }
    }

    private fun loadWorkout(weightWorkout: WeightWorkout?) = weightWorkout?.let {
        showExercisesList()
        workout_name.text = it.name
        presetExercisesList(it.exercises)
    } ?: showNoWorkoutScreen()

    private fun showExercisesList() {
        no_workout_screen.visibility = View.INVISIBLE
        exercise_list.visibility = View.VISIBLE
    }

    private fun showNoWorkoutScreen() {
        no_workout_screen.visibility = View.VISIBLE
        exercise_list.visibility = View.INVISIBLE
        workout_name.text = getString(R.string.rest_day)
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
