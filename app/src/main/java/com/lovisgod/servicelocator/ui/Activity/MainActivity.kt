package com.lovisgod.servicelocator.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.util.JwtHelper
import com.pixplicity.easyprefs.library.Prefs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var r = Runnable {
            validate()
        }
        Handler().postDelayed(r, 3000)
    }

    fun validate () {
        if (Prefs.getString("token", "").isNotEmpty()){

            val token = Prefs.getString("token", "")
            Log.i("TAG", "token is -> $token")
            val isExpired = JwtHelper.decode(token)
            if (isExpired) {
                Toast.makeText(this, "token expired", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, AuthActivity::class.java ))
                finish()
            }

            if (!isExpired){
                startActivity(Intent(this, BusinessActivity::class.java))
                finish()
            }
        } else {
            startActivity(Intent(this, AuthActivity::class.java ))
            finish()
        }
    }
}
