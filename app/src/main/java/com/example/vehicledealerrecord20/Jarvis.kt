package com.example.vehicledealerrecord20

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import androidx.core.app.ActivityCompat.recreate
import com.google.android.material.snackbar.Snackbar

class Jarvis {


    fun isInternetConnected(activity: Activity): Boolean {
        val cm: ConnectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifiConn: NetworkInfo? = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobileConn: NetworkInfo? = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

        if ((wifiConn != null && wifiConn.isConnected) || (mobileConn != null && mobileConn.isConnected)) {
            return true
        } else return false
    }

    fun showRetrySnackbar(view: View, msg: String, activity: Activity) {
        val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Retry") {
            recreate(activity)
        }
        snackbar.show()
    }

}