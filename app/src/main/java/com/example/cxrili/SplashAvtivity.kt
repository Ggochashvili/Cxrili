package com.example.cxrili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.cxrili.R
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth

class SplashAvtivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 3000// 1 sec
    private lateinit var signInButton: SignInButton
    private lateinit var auth: FirebaseAuth
    private val TAG: String = "LOGIN"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_avtivity)


        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,Registartion_Login ::class.java);
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}







