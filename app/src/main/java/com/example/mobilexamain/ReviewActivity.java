package com.example.mobilexamain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Button login = (Button) findViewById(R.id.loginR);

        Button notice = (Button) findViewById(R.id.rateR);

        Button qa = (Button) findViewById(R.id.qaR);


        Button search = (Button) findViewById(R.id.searchR);

        Button chose = (Button) findViewById(R.id.choseR);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                login();
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice();

            }
        });
        qa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                qa();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();

            }
        });
        chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chose();

            }
        });
    }
    public void login() {
        Intent intentL = new Intent(this, LoginActivity.class);
        startActivity(intentL);
    }
    public void notice() {
        Intent intentN = new Intent(this, RateActivity.class);
        startActivity(intentN);
    }
    public void qa() {
        Intent intentQ = new Intent(this, QaActivity.class);
        startActivity(intentQ);
    }
    public void search() {
        Intent intentS = new Intent(this, SearchActivity.class);
        startActivity(intentS);
    }
    public void chose() {
        Intent intentC = new Intent(this, ChoseActivity.class);
        startActivity(intentC);
    }

    //link buttons
    public void SamsungReview(View view){ //Samsung Galaxy Note 10 Plus 5G
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=nV5U0ud4UqM"));
        startActivity(recomendedintent);
    }
    public void SamsungReview2(View view){ //Samsung Galaxy Z Flip 5G
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ji63be1v-OU"));
        startActivity(recomendedintent);
    }
    public void SamsungReview3(View view){ //Samsung Galaxy Z Flip SM-F700F
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=KAKoW-0y3Cw"));
        startActivity(recomendedintent);
    }
    public void SamsungReview4(View view){ //Samsung Galaxy Tab S6 Lite review
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=npF6UqjmAYQ"));
        startActivity(recomendedintent);
    }
    public void SamsungReview5(View view){ //Samsung Galaxy M51
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=48cquPcvvec"));
        startActivity(recomendedintent);
    }
    public void SamsungReview6(View view){ //Samsung Galaxy Note20 Ultra
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kEUyF7tZi-4"));
        startActivity(recomendedintent);
    }
    public void AppleReview(View view){//Apple iPhone 11 Pro Max
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Zlv0qRK1jpA"));
        startActivity(recomendedintent);
    }
    public void AppleReview2(View view){//Apple iPhone 11 Pro
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=nxf41fMX_Y4"));
        startActivity(recomendedintent);
    }
    public void AppleReview3(View view){//Apple iPhone SE (2020)
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=jC5aperRCYc"));
        startActivity(recomendedintent);
    }
    public void AppleReview4(View view){//Apple iPhone X
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9Ca8zWJOlFQ"));
        startActivity(recomendedintent);
    }
    public void AppleReview5(View view){//Apple iPhone 7
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Y8nn0a2XNNs"));
        startActivity(recomendedintent);
    }
    public void AppleReview6(View view){//Apple iPhone 8 Plus
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lWcX0qGjRuY"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview(View view){//Huawei Mate 30 Pro 5G
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HxEbTFn7xNo"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview2(View view){//Huawei P40 Pro
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uK3jnIATgI4"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview3(View view){//Huawei Mate Xs
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Cw2mOxehd84"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview4(View view){//Huawei P Smart S
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=vW9Z4EU_mZI"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview5(View view){//Huawei Y8p
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BGuUfvYu1hk"));
        startActivity(recomendedintent);
    }
    public void HuaweiReview6(View view){//Huawei Y9a
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_I6JNN6xD6o"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview(View view){//xiaomi POCO X3 NFC Gaming
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7d8aieofYAA"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview2(View view){//Xiaomi Redmi Note 9 Pro
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ifBZDc1eMEQ"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview3(View view){//xiaomi POCO F2 Pro
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=f0YCdI43VSo"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview4(View view){//Xiaomi Poco M2 Pro
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ptoY3LmFOaE"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview5(View view){//Xiaomi Redmi 9A
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=D0vXi6SUnkQ"));
        startActivity(recomendedintent);
    }
    public void XiaomiReview6(View view){//Xiaomi Redmi K30 Ultra
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=569LIu6WQx8"));
        startActivity(recomendedintent);
    }
    public void LGReview(View view){//LG G8 ThinQ - The Bad Review
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JiSOMi0WviI"));
        startActivity(recomendedintent);
    }
    public void LGReview2(View view){//LG V60 ThinQ 5G
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RPgwnGtJ-wU"));
        startActivity(recomendedintent);
    }
    public void LGReview3(View view){//LG V30™ | AT&T
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tNeo8AkBJUI&feature=emb_logo"));
        startActivity(recomendedintent);
    }
    public void LGReview4(View view){//LG K30
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=19rJvkJDNCk"));
        startActivity(recomendedintent);
    }
    public void LGReview5(View view){//LG Q92 5G
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Vo4zRxiTscQ"));
        startActivity(recomendedintent);
    }
    public void LGReview6(View view){//LG Velvet
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=72H0_5i4FVs"));
        startActivity(recomendedintent);
    }
    public void SonyReview(View view){//Xperia 1 II -6.5" 21:9 CinemaWide 4K HDR
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Jr9Vhfwg3BI"));
        startActivity(recomendedintent);
    }
    public void SonyReview2(View view){//Xperia 5 -6.1" 21:9 CinemaWide FHD+ HDR
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DbK5iPSnAsY"));
        startActivity(recomendedintent);
    }
    public void SonyReview3(View view){//Xperia PRO -Fast 5G mmWave transmission
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5UZ62CWtaYE"));
        startActivity(recomendedintent);
    }
    public void SonyReview4(View view){//Sony Xperia 1
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=saMs3O-S3Es"));
        startActivity(recomendedintent);
    }
    public void SonyReview5(View view){//Sony Xperia L4
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3F-puef5oIw"));
        startActivity(recomendedintent);
    }
    public void SonyReview6(View view){//Sony Xperia 10
        Intent recomendedintent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=LHo6_uC5U0M"));
        startActivity(recomendedintent);
    }
}