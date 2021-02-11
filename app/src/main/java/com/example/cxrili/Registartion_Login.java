package com.example.cxrili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registartion_Login extends AppCompatActivity {

      public void RegistrationBtn(View v){
          Intent Registrationintent = new Intent(this,Registration.class);
          startActivity(Registrationintent);
          }

      public void LoginBtn(View V){
          Intent Loginintent = new Intent(this,Login.class);
          startActivity(Loginintent);
      }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion__login);
    }
}