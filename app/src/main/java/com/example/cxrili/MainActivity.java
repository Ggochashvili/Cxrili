package com.example.cxrili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void onMon(View view){
        Intent main = new Intent(this, monday.class);
        startActivity(main);

    }
    public void onSam(View view){
        Intent main = new Intent(this, samshabati.class);
        startActivity(main);

    }
    public void onOtx(View view){
        Intent main = new Intent(this, otxshabati.class);
        startActivity(main);

    }
    public void onXut(View view){
        Intent main = new Intent(this, xutshabati.class);
        startActivity(main);

    }
    public void onPar(View view){
        Intent main = new Intent(this, paraskevi.class);
        startActivity(main);

    }












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}