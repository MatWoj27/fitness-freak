package com.example.fitnessfreak.common

import android.widget.TextView

fun TextView.setTextWithAnimation(text: String, animation: TextViewAnimation) = when (animation) {
    TextViewAnimation.NO_ANIMATION -> this.text = text
    TextViewAnimation.SWIPE_LTR -> setTextWithSwipeAnimation(text, 150f, -150f)
    TextViewAnimation.SWIPE_RTL -> setTextWithSwipeAnimation(text, -150f, 150f)
}

fun TextView.setTextWithSwipeAnimation(
    text: String,
    exitTranslation: Float,
    startEnterTranslation: Float
) {
    this.animate().translationX(exitTranslation).alpha(0f).setDuration(150)
        .withEndAction {
            this.text = text
            translationX = startEnterTranslation
            animate().translationX(0f).alpha(1f).setDuration(150).start()
        }
}

enum class TextViewAnimation {
    NO_ANIMATION,
    SWIPE_LTR,
    SWIPE_RTL
}