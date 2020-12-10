package com.example.fitnessfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessfreak.weightworkout.WeightWorkoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weight_workouts_btn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    WeightWorkoutActivity::class.java
                )
            )
        }
    }
}
