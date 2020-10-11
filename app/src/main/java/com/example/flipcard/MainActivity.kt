package com.example.flipcard

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baling = findViewById<ImageView>(R.id.img_baling)
        var flip = false

        baling.setOnClickListener {
            val oa1 = ObjectAnimator.ofFloat(baling, "scaleX", 1f, 0f)
            val oa2 = ObjectAnimator.ofFloat(baling, "scaleX", 0f, 1f)
            oa1.interpolator = DecelerateInterpolator()
            oa2.interpolator = AccelerateDecelerateInterpolator()
            if (flip == false){
                flip = true
                oa1.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        baling.setImageResource(R.drawable.uno_back)

                        oa2.start()
                    }
                })
            }
            else {
                flip = false
                oa1.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        baling.setImageResource(R.drawable.uno_reverse)

                        oa2.start()
                    }
                })
            }
            oa1.start()
        }

    }
}