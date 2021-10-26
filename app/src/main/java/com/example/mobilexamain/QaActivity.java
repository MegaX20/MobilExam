package com.example.mobilexamain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);

        Button login = (Button) findViewById(R.id.loginQ);

        Button rate = (Button) findViewById(R.id.rateQ);



        Button review = (Button) findViewById(R.id.reviewQ);

        Button search= (Button) findViewById(R.id.searchQ);
        Button chose= (Button) findViewById(R.id.choseQ);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                login();
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate();
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                review();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
        chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose();
            }
        });

    }
    public void login() {
        Intent intentL = new Intent(this, LoginActivity.class);
        startActivity(intentL);
    }
    public void rate() {
        Intent intentRa = new Intent(this, RateActivity.class);
        startActivity(intentRa);
    }
    public void review() {
        Intent intentR = new Intent(this, ReviewActivity.class);
        startActivity(intentR);
    }
    public void search() {
        Intent intentC = new Intent(this, SearchActivity.class);
        startActivity(intentC);
    }
    public void chose() {
        Intent intentC = new Intent(this, ChoseActivity.class);
        startActivity(intentC);
    }
}