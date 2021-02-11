package com.example.cxrili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Login extends AppCompatActivity {

    public void GobackBtn(View v) {
        finish();
}
    public void EnterBtn(View v){
        Intent MainActivityintent = new Intent(this, MainActivity.class);
        startActivity(MainActivityintent);


    }














    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}