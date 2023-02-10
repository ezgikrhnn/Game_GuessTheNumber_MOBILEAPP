package com.info.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView textViewKalanHak;
    private TextView textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        //tahmin sayfası açıldığı anda rastgele bir sayi üretilmesi gerekiyor.
        Random r =new Random();


        rastgeleSayi = r.nextInt(101);  //101 yazdıgımda 0-100 arasında bir sayi üretir.
        Log.e("Rastgele Sayı", String.valueOf(rastgeleSayi));



        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //her basıldıgında sayac 1 azalmalı:
                sayac = sayac -1;

                int tahmin = Integer.parseInt(editTextGirdi.getText().toString()); //editText içinde kullanıcının girdiği veriyi tahmin olaak almamızı sağlıyor.

                if (tahmin ==rastgeleSayi){ //dogru cevaptır, sonucActivitye gecmem gerekiyor.

                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                    i.putExtra("sonuc", true);
                    startActivity(i);      //bu şekilde diğer sayfaya gecisi sağladım.
                    finish();              //yapıyorum ki sonuc sayfasından geri tahmin sayfasına dönmesin.
                    return;                //doğru cevaba ulaşınca geri kalan işlemlerin yapılmasına gerek kalmadıgı için return yapıyorum.
                }
                if (tahmin > rastgeleSayi){
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak: " +sayac);

                }
                if (tahmin < rastgeleSayi){
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak: " +sayac);

                }
                if (sayac ==0){

                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                    i.putExtra("sonuc", false);
                    startActivity(i);      //bu şekilde diğer sayfaya gecisi sağladım.
                    finish();              //yapıyorum ki sonuc sayfasından geri tahmin sayfasına dönmesin.
                }

                editTextGirdi.setText("");    //işlemler bittiğinde sıfırlansın.


                //startActivity(new Intent( TahminActivity.this, SonucActivity.class));  //Tahinactivitydeyim SonucActivity'e gitmek istiyorum.
                //finish(); //diğer sayfalardan farklı olarak urada finish yaptım cunku backstack uyguluyorum. oyun bitince ana ekrana geri dönebileyim diye.
            }
        });
    }
}