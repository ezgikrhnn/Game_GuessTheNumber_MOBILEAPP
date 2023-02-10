package com.info.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonBasla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonBasla = findViewById(R.id.buttonBasla);
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sayfalar arası geçişi yapacagım:
                startActivity(new Intent(MainActivity.this, TahminActivity.class));  //mainactivitydeyim TahminActivity'e gitmek istiyorum.


            }
        });

    }
}