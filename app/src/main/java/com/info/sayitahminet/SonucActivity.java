package com.info.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

    private ImageView imageView2;
    private TextView textViewSonuc;
    private Button buttonTekrar;

    private boolean sonuc;    //true ya da false bu sayfaya bir sonuc gelecek.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageView2 = findViewById(R.id.imageView2);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);



        getIntent().getBooleanExtra("sonuc", false);
        if(sonuc){
            textViewSonuc.setText("KAZANDINIZ !!");
            imageView2.setImageResource(R.drawable.dogru_resim);
        }else{
            textViewSonuc.setText("KAYBETTİNİZ!!!");
            imageView2.setImageResource(R.drawable.yanlis_resim);
        }


        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            startActivity(new Intent(SonucActivity.this, TahminActivity.class));  //Sonucactivitydeyim tekrar TahminActivity'e gitmek istiyorum.
            finish(); //sonucActivityi de siliyorum ki tahmin et butonuna basıldıgında geri kendisine dönmesin.

        }
    });


    }
}