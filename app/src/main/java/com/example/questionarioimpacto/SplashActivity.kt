package com.example.questionarioimpacto

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val handle = Handler()
        handle.postDelayed({ mostrarLogin() }, 2000)

    }

    private fun mostrarLogin() {
        val intent = Intent(this@SplashActivity, TermsConditionsActivity::class.java)
        startActivity(intent)
        finish()
    }
}