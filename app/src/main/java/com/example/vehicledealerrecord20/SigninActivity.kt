package com.example.vehicledealerrecord20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val jarvis = Jarvis()
        // Checking Internet Connectivity
        val netConnected: Boolean = jarvis.isInternetConnected(this)

        if (netConnected) {

        } else {
            jarvis.showRetrySnackbar(si_root_view, "No Internet Connection", this)
        }
    }
}