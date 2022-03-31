package com.example.championsleague.splash

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.championsleague.R
import com.example.championsleague.presentation.list.ListTeamsActivity
import com.example.championsleague.tools.Constants.DEFAULT_LENGTH_ANIMATION
import com.example.championsleague.tools.Constants.DEFAULT_LENGTH_SPLASH

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val imgLogo = findViewById<ImageView>(R.id.imgLogo)
        val scaleDown = ObjectAnimator.ofPropertyValuesHolder(
            imgLogo,
            PropertyValuesHolder.ofFloat("scaleX", 1.2f),
            PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        )
        scaleDown.interpolator = BounceInterpolator()
        scaleDown.duration = DEFAULT_LENGTH_ANIMATION
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.RESTART
        scaleDown.start()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ListTeamsActivity::class.java))
            finish()
        }, DEFAULT_LENGTH_SPLASH)
    }
}