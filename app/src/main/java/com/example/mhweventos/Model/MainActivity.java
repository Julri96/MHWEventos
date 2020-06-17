package com.example.mhweventos.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mhweventos.Model.EventList;
import com.example.mhweventos.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMHW, btnMHWI, btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMHW = findViewById(R.id.btnMHW);
        btnMHWI = findViewById(R.id.btnMHWI);
        btnAll = findViewById(R.id.btnAll);
        btnMHW.setOnClickListener(this);
        btnMHWI.setOnClickListener(this);
        btnAll.setOnClickListener(this);
    }

    /*según que boton pulses manda un valor distinto mediante el intent, aunque los tres llevan a la misma class*/
    //Los Log.d los use para saber si funcionaban bien los botones
    @Override
    public void onClick(View v) {
        if (v == btnMHW) {
            Intent i = new Intent(this, EventList.class);
            i.putExtra("modo", 0);
            //Log.d("boton", "boton1");
            startActivity(i);

        } else if (v == btnMHWI) {
            Intent i = new Intent(this, EventList.class);
            i.putExtra("modo", 1);
            //Log.d("boton", "boton2");
            startActivity(i);
        } else if (v == btnAll) {
            Intent i = new Intent(this, EventList.class);
            i.putExtra("modo", 2);
            //Log.d("boton", "boton3");
            startActivity(i);
        }

    }
}
