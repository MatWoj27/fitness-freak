package com.example.fitnessfreak.common

import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    ContextCompat.getDrawable(this.context, drawableRes)?.let {
        val divider = DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
        )
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}