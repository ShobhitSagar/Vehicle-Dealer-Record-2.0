package com.devss.vehicledealerrecord20

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    val jarvis = Jarvis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

    }

    fun addVehicle(view: android.view.View) {
        startActivity(Intent(this, AddVehicleActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present
        menuInflater.inflate(R.menu.menu_action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sign_out -> {
                signOut()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun signOut() {
        // TODO: Put confirmation dialog
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
        dialog.setTitle("Logout")
        dialog.setMessage("Are you sure?")
        //TODO: dialog.setIcon(icon)
        dialog.setPositiveButton("Yes") { _, _ ->
            Firebase.auth.signOut()
            jarvis.showShortToast(this, "Signed Out")
            startActivity(Intent(this, SigninActivity::class.java))
            finish()
        }
        dialog.setNegativeButton("No") {_, _ -> }
        dialog.create()
        dialog.show()
    }
}