package com.example.vehicledealerrecord20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // For Fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val jarvis = Jarvis()
        // To check internet connection is available or not
        val netConnected: Boolean = jarvis.isInternetConnected(this)

        if (netConnected) {

            // Timer delay for start screen
            Handler().postDelayed({
                val intent = Intent(this, SigninActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        } else jarvis.showRetrySnackbar(root_view, "No Internet!", this) // show snackbar if no internet connection

    }
}