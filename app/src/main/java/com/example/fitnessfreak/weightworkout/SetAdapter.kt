package com.example.fitnessfreak.weightworkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessfreak.databinding.SetItemBinding
import com.example.fitnessfreak.weightworkout.models.WeightSet

class SetAdapter(private val weightExercises: List<WeightSet>) :
    RecyclerView.Adapter<SetAdapter.SetViewHolder>() {

    inner class SetViewHolder(private val binding: SetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weightSet: WeightSet, setNumber: Int) {
            binding.weightSet = weightSet
            binding.setNumber = setNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        return SetViewHolder(
            SetItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = weightExercises.size

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        holder.bind(weightExercises[position], position + 1)
    }
}