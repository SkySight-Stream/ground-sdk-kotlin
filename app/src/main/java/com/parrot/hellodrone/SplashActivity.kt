package com.parrot.hellodrone  // Keep your package name as defined in AndroidManifest.xml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.parrot.hellodrone.databinding.ActivitySplashBinding  // Adjusted to match your package name

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding layout
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load animation
        val scaleAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.animation_scale)

        // Makes the text visible and starts the animation
        binding.SplashTextView.visibility = View.VISIBLE
        binding.SplashTextView.startAnimation(scaleAnimation)

        // Start the next activity after animation ends
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                // Start next activity after animation ends
                val intent = Intent(this@SplashActivity, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }
}